package com.hunter.framework.googleauthenticator.service;

import com.hunter.framework.googleauthenticator.pojo.GoogleSecret;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * <p>Description: TODO</p>
 *
 * @author : tivy.He
 * @date : 2020-11-17 13:59:36
 */
@Component
public interface GoogleSecretService {

    GoogleSecret findById(String id);

    List<GoogleSecret> findAll();

    void insert(GoogleSecret googleSecret);

}
