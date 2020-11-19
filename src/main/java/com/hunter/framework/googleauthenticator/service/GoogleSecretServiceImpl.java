package com.hunter.framework.googleauthenticator.service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.hunter.framework.googleauthenticator.mapper.GoogleSecretMapper;
import com.hunter.framework.googleauthenticator.pojo.GoogleSecret;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * <p>Description: TODO</p>
 *
 * @author : tivy.He
 * @date : 2020-11-17 14:00:12
 */
@Service
public class GoogleSecretServiceImpl implements GoogleSecretService {

    private  final Logger logger = LoggerFactory.getLogger(GoogleSecretServiceImpl.class);

    @Autowired
    private GoogleSecretMapper googleSecretMapper;

    @Override
    public GoogleSecret findById(String id){
        return googleSecretMapper.findById(id);
    }

    @Override
    public List<GoogleSecret> findAll() {
        logger.info("findAll---------------");
        Page<GoogleSecret> page = PageHelper.startPage(1, 10);
        //PageHelper.clearPage();
        List<GoogleSecret> googleSecretList = googleSecretMapper.findAll();
        logger.info("total:{}",page.getTotal());
        return googleSecretList;
    }

    @Override
    public void insert(GoogleSecret googleSecret) {
        googleSecretMapper.insert(googleSecret);
    }
}
