package com.rong.spcloud.service.servicefallback;/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/5/15
*/


import com.rong.spcloud.service.OrderService;
import org.springframework.stereotype.Component;

@Component
public class OrderServiceFallback implements OrderService{
    @Override
    public String getPaymentInfo_OK(Integer id) {
       return Thread.currentThread().getName() + "consumer---globleFallBack--=" + "\t"+"网络繁忙或异常!稍后再试";
    }

    @Override
    public String getPaymentInfo_timeout(Integer id) {
        return  Thread.currentThread().getName() + "consumer---globleFallBack--id =" + id +"\t"+"网络繁忙或异常!稍后再试";
    }
}
