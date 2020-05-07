package com.rong.spcloud.config;/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/4/29
*/


import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class ApplicationContextConfig {

    @Bean
    @LoadBalanced
    public RestTemplate getResttpl(){
        return new RestTemplate();
    }
}
