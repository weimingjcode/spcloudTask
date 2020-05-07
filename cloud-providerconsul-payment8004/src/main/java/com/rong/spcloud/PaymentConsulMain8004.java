package com.rong.spcloud;
/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/4/29
*/


import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

@SpringBootApplication
@EnableDiscoveryClient
public class PaymentConsulMain8004 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentConsulMain8004.class,args);
    }
}
