package com.rong.spcloud.controller;/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/4/29
*/

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@Slf4j
public class PaymentConsulController {
    @Value("${server.port}")
    private String port;

    @GetMapping(value = "/payment/zk")
    public String paymentZK(){
        log.info("spcloud to consul--"+port+"\t"+ UUID.randomUUID().toString());
        return "spcloud to consul--"+port+"\t"+ UUID.randomUUID().toString();
    }
}
