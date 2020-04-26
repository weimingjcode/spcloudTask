package com.rong.spcloud.controller;
/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/4/23
*/

import com.rong.spcloud.entity.Payment;
import com.rong.spcloud.entity.deal.CommonResult;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@RestController
@Slf4j
public class OrderController {
    public static final String PAYMENT_URL = "http://localhost:8001";

    @Resource
    private RestTemplate restTemplate;

    @GetMapping("/consumer/payment/creatPayment")
    public CommonResult creatPayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/creatPayment",payment,                 CommonResult.class);
    }

    @GetMapping("/consumer/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        log.info(PAYMENT_URL+"/payment/getPaymentById/"+id);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id,                     CommonResult.class);
    }
}
