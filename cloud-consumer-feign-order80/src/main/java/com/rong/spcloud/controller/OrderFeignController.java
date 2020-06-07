package com.rong.spcloud.controller;/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/5/13
*/

import com.rong.spcloud.entity.Payment;
import com.rong.spcloud.entity.deal.CommonResult;
import com.rong.spcloud.service.PaymentService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class OrderFeignController {

    @Resource
    private PaymentService paymentService;

    @GetMapping(value = "/consumer/getPaymentById/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable(value = "id") long id){
       return paymentService.getPaymentById(id);
    }

    @GetMapping(value = "/consumer/timeout")
    public String feignTimeoutTest(){
        return paymentService.feignTimeoutTest();
    }
}
