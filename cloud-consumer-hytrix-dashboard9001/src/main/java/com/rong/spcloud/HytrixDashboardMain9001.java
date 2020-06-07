package com.rong.spcloud;/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/5/27
*/

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.hystrix.dashboard.EnableHystrixDashboard;

@SpringBootApplication
@EnableHystrixDashboard
public class HytrixDashboardMain9001 {
    public static void main(String[] args) {
        SpringApplication.run(HytrixDashboardMain9001.class,args);
    }
}
