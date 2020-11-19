package com.phy.framework.googleauthenticator.mapper;

import com.phy.framework.googleauthenticator.pojo.GoogleSecret;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * <p>Description: TODO</p>
 *
 * @author : tivy.He
 * @date : 2020-11-17 13:58:33
 */

@Mapper
public interface GoogleSecretMapper {

    GoogleSecret findById(String id);

    List<GoogleSecret> findAll();

    void insert(GoogleSecret googleSecret);

}
