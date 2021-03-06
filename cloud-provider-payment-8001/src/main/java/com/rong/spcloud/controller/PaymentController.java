package com.rong.spcloud.controller;
/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/4/21
*/

import com.rong.spcloud.entity.Payment;
import com.rong.spcloud.entity.deal.CommonResult;
import com.rong.spcloud.service.PaymentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;
import java.util.concurrent.TimeUnit;

@RestController
@Slf4j
public class PaymentController {

    @Resource
    PaymentService paymentService;

    @Value("${server.port}")
    private String port;

    @Resource
    private DiscoveryClient discoveryClient;

    @PostMapping(value = "/payment/creatPayment")
    public CommonResult creatPayment(@RequestBody Payment payment){
        int rst = paymentService.creatPayment(payment);
        log.info("payment插入结果---"+rst);
        if (rst > 0) return new CommonResult<>(200,"插入成功--port--"+port,payment);
        else return new CommonResult<>(444,"插入失败--"+port,null);
    }

    @GetMapping(value = "/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        Payment payment = paymentService.getPaymentById(id);
        log.info("查询结果--"+payment);
        if (payment != null) return new CommonResult(200,"查询成功--port--"+port,payment);
        else return new CommonResult(444,"查询失败 id=" + id+"port--"+port,null);
    }

    @GetMapping(value = "/payment/discovery")
    public String discovery(){
//        List<String> services = discoveryClient.getServices();
//        for(String service : services){
//            log.info("servie---"+service);
//        }
//
//        List<ServiceInstance> instances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
//        for (ServiceInstance serviceInstance : instances){
//            log.info(serviceInstance.getHost()+"\t"+serviceInstance.getInstanceId()+"\t"+serviceInstance.getPort()+"\t"+serviceInstance.getUri());
//        }
        return port;
    }

    @GetMapping(value = "/payment/timeout")
    public String feignTimeoutTest(){
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return port;
    }
}
