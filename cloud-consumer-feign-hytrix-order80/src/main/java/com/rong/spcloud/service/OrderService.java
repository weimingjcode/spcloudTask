package com.rong.spcloud.service;
/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/5/14
*/

import com.rong.spcloud.service.servicefallback.OrderServiceFallback;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Component
@FeignClient(value = "CLOUD-HYSTRIX-PROVIDER-PAYMENT",fallback = OrderServiceFallback.class)
//@FeignClient(value = "CLOUD-HYSTRIX-PROVIDER-PAYMENT")
public interface OrderService {

    @GetMapping(value = "/getPaymentInfo_OK/{id}")
    String getPaymentInfo_OK(@PathVariable("id") Integer id);

    @GetMapping(value = "/getPaymentInfo_timeout/{id}")
    String getPaymentInfo_timeout(@PathVariable("id") Integer id);

}
