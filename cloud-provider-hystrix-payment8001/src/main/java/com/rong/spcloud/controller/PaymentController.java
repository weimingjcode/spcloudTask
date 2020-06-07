package com.rong.spcloud.controller;/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/5/14
*/

import com.rong.spcloud.service.PaymentService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class PaymentController {

    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String serverPort;

    @GetMapping(value = "/getPaymentInfo_OK/{id}")
    public String getPaymentInfo_OK(@PathVariable("id") Integer id){
        return paymentService.getPaymentInfo_OK(id);
    }

    @GetMapping(value = "/getPaymentInfo_timeout/{id}")
    public String getPaymentInfo_timeout(@PathVariable("id") Integer id){
        return paymentService.getPaymentInfo_timeOut(id);
    }

    @GetMapping(value = "/getPayment/circuitBreaker/{id}")
    public String getPayment_circuitBreaker(@PathVariable("id") Integer id){
        return paymentService.paymentCircuitBreaker(id);
    }
}
