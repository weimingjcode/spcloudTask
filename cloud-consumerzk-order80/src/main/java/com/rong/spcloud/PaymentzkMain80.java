package com.rong.spcloud;
/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/4/28
*/


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentzkMain80 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentzkMain80.class);
    }
}

