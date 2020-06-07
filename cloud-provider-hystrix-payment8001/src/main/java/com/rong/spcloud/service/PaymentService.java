package com.rong.spcloud.service;/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/5/14
*/

import cn.hutool.core.util.IdUtil;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.concurrent.TimeUnit;

@Service
@Slf4j
public class PaymentService {

    public String getPaymentInfo_OK(Integer id){
        try {
            TimeUnit.SECONDS.sleep(4);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String rst = Thread.currentThread().getName() + "-----id =" + id;
        log.info(rst);
        return rst;
    }

    @HystrixCommand(fallbackMethod = "fallback_timeout",commandProperties = {
            @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "7000")
    })
    public String getPaymentInfo_timeOut(Integer id){

//        int a = 1/0;
        String rst = Thread.currentThread().getName() + "-----id =" + id +"\t"+"耗时3秒";
        log.info(rst);
        return rst;
    }

    public String fallback_timeout(Integer id){
        return  Thread.currentThread().getName() + "provider-----id =" + id +"\t"+"网络繁忙或异常!稍后再试";
    }

    //断路器部分---------------------------------------------

    @HystrixCommand(fallbackMethod = "paymentCircuitBreakerFallback",commandProperties = {
        @HystrixProperty(name = "circuitBreaker.enabled" , value = "true"),
        @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold" , value = "10"),
        @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds" , value = "10000"),
        @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage" , value = "60"),
    })
    public String paymentCircuitBreaker(@PathVariable("id") Integer id){
        if (id < 0){
            throw new RuntimeException();
        }
        String serialNum = IdUtil.simpleUUID();
        return new Thread().getName() + "\t" + "success serialNumber ---" + serialNum;
    }

    public String paymentCircuitBreakerFallback(@PathVariable("id") Integer id){
        return "不可为负数  稍后再试！" + id;
    }

}
