package com.rong.spcloud.lb;
/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/5/7
*/

import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

@Component
@Slf4j
public class MyLoadBalancer implements LoadBalancer{

    private AtomicInteger atomicInteger = new AtomicInteger(0);

    public final int getAndIncrement(){
        int current = 0;
        int next = 0;
        do{
            current = atomicInteger.get();
            next = current >= Integer.MAX_VALUE ? 0 : current + 1;
        }while (!atomicInteger.compareAndSet(current,next));
        log.info("访问次数:  "+ next);
        return next;
    }

    @Override
    public ServiceInstance choseServiceInstance(List<ServiceInstance> serviceInstances) {
        Integer index = getAndIncrement() % serviceInstances.size();
        return serviceInstances.get(index);
    }
}
