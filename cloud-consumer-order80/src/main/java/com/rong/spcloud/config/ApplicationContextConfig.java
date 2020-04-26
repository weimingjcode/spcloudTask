package com.rong.spcloud.config;
/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/4/23
*/

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }
}
