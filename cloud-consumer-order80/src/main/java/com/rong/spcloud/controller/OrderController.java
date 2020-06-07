package com.rong.spcloud.controller;
/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/4/23
*/

import com.rong.spcloud.entity.Payment;
import com.rong.spcloud.entity.deal.CommonResult;
import com.rong.spcloud.lb.LoadBalancer;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;
import java.net.URI;
import java.util.List;

@RestController
@Slf4j
public class OrderController {
//    public static final String PAYMENT_URL = "http://localhost:8001";
    public static final String PAYMENT_URL = "http://CLOUD-PAYMENT-SERVICE";

    @Resource
    private RestTemplate restTemplate;

    @Resource
    LoadBalancer loadBalancer;

    @Resource
    private DiscoveryClient discoveryClient;

    @GetMapping("/consumer/payment/creatPayment")
    public CommonResult creatPayment(Payment payment){
        return restTemplate.postForObject(PAYMENT_URL+"/payment/creatPayment",payment,                 CommonResult.class);
    }

    @GetMapping("/consumer/payment/getPaymentById/{id}")
    public CommonResult getPaymentById(@PathVariable("id") Long id){
        log.info(PAYMENT_URL+"/payment/getPaymentById/"+id);
        return restTemplate.getForObject(PAYMENT_URL+"/payment/getPaymentById/"+id,                     CommonResult.class);
    }

    @GetMapping("/consumer/payment/getPaymentEntityById/{id}")
    public CommonResult getPaymentEntityById(@PathVariable("id") Long id){
        ResponseEntity<CommonResult> responseEntity = restTemplate.getForEntity(PAYMENT_URL+"/payment/getPaymentById/"+id,CommonResult.class);
        if (responseEntity.getStatusCode().is2xxSuccessful()) return responseEntity.getBody();
        else return new CommonResult(444,"请求失败");
    }

    @GetMapping("/consumer/order/discovery")
    public Object discovery(){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-ORDER-SERVICE");
        for (ServiceInstance serviceInstance : serviceInstances){
            log.info(serviceInstance.getUri() + "\t" + serviceInstance.getInstanceId());
        }
        return discoveryClient;
    }

    @GetMapping("/consumer/paymentlb/getPaymentEntityById/{id}")
    public String getPaymentLB(@PathVariable("id") long id){
        List<ServiceInstance> serviceInstances = discoveryClient.getInstances("CLOUD-PAYMENT-SERVICE");
        if(serviceInstances.size()<0 || serviceInstances == null){
            return null;
        }
        ServiceInstance serviceInstance = loadBalancer.choseServiceInstance(serviceInstances);
        URI uri = serviceInstance.getUri();
       return restTemplate.getForObject(uri+"/payment/discovery", String.class);
    }
}
