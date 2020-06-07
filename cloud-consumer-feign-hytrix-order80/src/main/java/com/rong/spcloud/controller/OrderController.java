package com.rong.spcloud.controller;/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/5/14
*/

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.rong.spcloud.service.OrderService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

@RestController
//@DefaultProperties(defaultFallback = "fallback_timeout")
//@DefaultProperties(defaultFallback = "fallback_timeout",commandProperties = {
//           @HystrixProperty(name = "execution.isolation.thread.timeoutInMilliseconds",value = "3000")})
public class OrderController {

    @Resource
    private OrderService orderService;

    @GetMapping(value = "/consumer/getPaymentInfo_OK/{id}")
//    @HystrixCommand
    public String getPaymentInfo_OK(@PathVariable("id") Integer id){
       return orderService.getPaymentInfo_OK(id);
    }

    @GetMapping(value = "/consumer/getPaymentInfo_timeout/{id}")
    @HystrixCommand(fallbackMethod = "fallback_timeout",commandProperties = {
            @HystrixProperty(name="execution.isolation.thread.timeoutInMilliseconds",value="2000")
    })
    public String getPaymentInfo_timeout(@PathVariable("id") Integer id){
        return orderService.getPaymentInfo_timeout(id);
    }

    public String fallback_timeout(){
        return  Thread.currentThread().getName() + "consumer-----=" + "\t"+"网络繁忙或异常!稍后再试";
    }

    public String fallback_timeout(Integer id){
        return  Thread.currentThread().getName() + "consumer-----id =" + id +"\t"+"网络繁忙或异常!稍后再试";
    }

    public static void main(String[] args) {

        String[] strs = {"a1","a2","a3"};
        List<String> list = Arrays.asList(strs);
        list.stream().filter(s -> !s.equals("a1")).forEach(s-> System.out.println(s));

        list.stream().filter(new Predicate<String>() {
            @Override
            public boolean test(String s) {
                return !s.equals("a1");
            }
        }).forEach(s-> System.out.println(s));
    }
}
