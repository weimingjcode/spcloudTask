package com.rong.spcloud.controller;
/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/4/30
*/

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {

    public static final String URL_PAYMENT = "http://consul-provider-payment";

    @Value("${server.port}")
    private String port;

    @Resource
    private RestTemplate restTemplate;

    @GetMapping(value = "/consumer/consulpayment")
    public String getConsulPayment(){
        String rst = restTemplate.getForObject(URL_PAYMENT+"/payment/zk",String.class);
        log.info("interfacePort---"+port+"\n"+rst);
        return rst;
    }
}
