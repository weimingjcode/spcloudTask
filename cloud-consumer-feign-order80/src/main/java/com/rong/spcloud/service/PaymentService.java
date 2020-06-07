package com.rong.spcloud.service;
/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/5/13
*/

import com.rong.spcloud.entity.Payment;
import com.rong.spcloud.entity.deal.CommonResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-PAYMENT-SERVICE")
public interface PaymentService {

    @GetMapping(value = "/payment/getPaymentById/{id}")
    CommonResult<Payment> getPaymentById(@PathVariable("id") Long id);

    @GetMapping(value = "/payment/timeout")
    String feignTimeoutTest();
}
