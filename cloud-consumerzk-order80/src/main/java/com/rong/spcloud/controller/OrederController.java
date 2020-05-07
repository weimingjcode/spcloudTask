package com.rong.spcloud.controller;
/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/4/28
*/

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.util.UUID;

@RestController
@Slf4j
public class OrederController {


    public static final String INVOKE_URL = "http://cloud-provider-payment";

    @Resource
    private RestTemplate restTemplate;

    @Value("${server.port}")
    private String port;

    @RequestMapping(value = "/payment/zk")
    public String paymentZK(){
        log.info("spcloud to zookeeper--"+port+"\t"+ UUID.randomUUID().toString());
        return "spcloud to zookeeper--"+port+"\t"+ UUID.randomUUID().toString();
    }

    @GetMapping(value = "/consumer/paymentzk")
    public String getPayment(){
        return restTemplate.getForObject(INVOKE_URL+"/payment/zk",String.class);
    }
}
