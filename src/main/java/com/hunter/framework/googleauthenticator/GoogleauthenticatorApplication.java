package com.hunter.framework.googleauthenticator;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hunter.framework.googleauthenticator.mapper")
public class GoogleauthenticatorApplication {

	public static void main(String[] args) {
		SpringApplication.run(GoogleauthenticatorApplication.class, args);
	}

}
