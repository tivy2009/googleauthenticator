package com.phy.framework.googleauthenticator.controller;

import com.google.zxing.WriterException;
import com.phy.framework.googleauthenticator.authenticator.GoogleAuthenticator;
import com.phy.framework.googleauthenticator.authenticator.QRCodeUtil;
import com.phy.framework.googleauthenticator.pojo.GoogleSecret;
import com.phy.framework.googleauthenticator.service.GoogleSecretService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <p>Description: TODO</p>
 *
 * @author : tivy.He
 * @date : 2020-11-17 14:02:32
 */
@RestController
public class GoogleSecretController {

    @Autowired
    private GoogleSecretService googleSecretService;

    @RequestMapping(value = {"","/","/list"})
    public ModelAndView queryAll(ModelMap map){
        List<GoogleSecret> list = googleSecretService.findAll();
        if(list != null && !list.isEmpty()){
            map.put("list",list);
        }
        ModelAndView modelAndView= new ModelAndView("googleSecret/list");
        return modelAndView;
    }

    @RequestMapping(value = "/insert",method = {RequestMethod.GET})
    public ModelAndView enterInsert(@ModelAttribute("googleSecret")GoogleSecret googleSecret, ModelMap map){
        ModelAndView modelAndView= new ModelAndView("googleSecret/insert");
        return modelAndView;
    }

    @RequestMapping(value = "/insert", method = {RequestMethod.POST})
    public ModelAndView doInsert(GoogleSecret googleSecret, RedirectAttributes redirectAttributes){
        ModelAndView modelAndView= new ModelAndView("redirect:/list");
        if(googleSecret != null
                && googleSecret.getAccount() != null && googleSecret.getAccount().length() >0
                && googleSecret.getIssuer() != null && googleSecret.getIssuer().length() >0)
        {
            String secret = GoogleAuthenticator.generateSecretKey();
            googleSecret.setSecret(secret);
            googleSecret.setStatus(1);
            googleSecretService.insert(googleSecret);
            redirectAttributes.addFlashAttribute("msg","Insert GoogleSecret Success!");
        }else{
            redirectAttributes.addFlashAttribute("error","Insert GoogleSecret Failure!");
        }
        return modelAndView;
    }

    @RequestMapping(value = "/qrCode/{id}", method = {RequestMethod.GET})
    public ModelAndView viewQrCode(HttpServletRequest request, HttpServletResponse response, @PathVariable String id, ModelMap map){
        if(id != null && id.trim().length() > 0){
            GoogleSecret googleSecret = googleSecretService.findById(id);
            if(googleSecret != null){
                map.put("googleSecret",googleSecret);
                ModelAndView modelAndView= new ModelAndView("googleSecret/qrCode");
                return modelAndView;
            }
        }
        ModelAndView modelAndView= new ModelAndView("googleSecret/list");
        return modelAndView;
    }

    @RequestMapping(value = "/qrCodeImg/{id}", method = {RequestMethod.GET})
    public void viewQrCodeImg(HttpServletRequest request, HttpServletResponse response, @PathVariable String id){
        if(id != null && id.trim().length() > 0){
            GoogleSecret googleSecret = googleSecretService.findById(id);
            if(googleSecret != null){
                String secret = googleSecret.getSecret();
                String account = googleSecret.getAccount();
                String issuer = googleSecret.getIssuer();
                String content = QRCodeUtil.createGoogleAuthQRCodeData(secret,account,issuer);
                try{
                    QRCodeUtil.writeToStream(content,response.getOutputStream(),300,300);
                    return;
                }catch (IOException e) {
                    e.printStackTrace();
                } catch (WriterException e) {
                    e.printStackTrace();
                }
            }
        }
        throw new RuntimeException("Illegal account");
    }

    @RequestMapping(value = "/checkCode/{id}/{code}", method = {RequestMethod.GET})
    public Map<String,String> checkCode(@PathVariable String id, @PathVariable Integer code) {
        Map<String,String> resultMap = new HashMap<>();
        if(id != null && id.trim().length() > 0){
            GoogleSecret googleSecret = googleSecretService.findById(id);
            if(googleSecret != null){
                String secret = googleSecret.getSecret();
                long timeMillis = System.currentTimeMillis();
                GoogleAuthenticator ga = new GoogleAuthenticator();
                ga.setWindowSize(0);
                boolean result = ga.check_code(secret, code, timeMillis);
                if(result){
                    resultMap.put("result","success");
                    return resultMap;
                }
            }
        }
        resultMap.put("result","failure");
        return resultMap;
    }

}
