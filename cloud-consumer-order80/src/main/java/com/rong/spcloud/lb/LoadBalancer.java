package com.rong.spcloud.lb;/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/5/7
*/

import org.springframework.cloud.client.ServiceInstance;

import java.util.List;

public interface LoadBalancer {

    ServiceInstance choseServiceInstance(List<ServiceInstance> serviceInstances);
}
