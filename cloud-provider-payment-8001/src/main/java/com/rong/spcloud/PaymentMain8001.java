package com.rong.spcloud;
/*
 @author jm
 @DESCRIPTION payment8001主启动类
 @create 2020/4/17
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

//@ComponentScan({"com.rong.spcloud.service",
//                "com.rong.spcloud.dao",
//                "com.rong.spcloud.controller"})
@SpringBootApplication
public class PaymentMain8001 {
    public static void main(String[] args) {
        SpringApplication.run(PaymentMain8001.class);
    }
}
