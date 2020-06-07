package com.rong.spcloud.config;/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/5/13
*/


import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignConfig {

    @Bean
    public Logger.Level feignLogerLevel(){
        return Logger.Level.FULL;
    }
}
