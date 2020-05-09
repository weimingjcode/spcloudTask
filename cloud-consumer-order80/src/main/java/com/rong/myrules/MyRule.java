package com.rong.myrules;
/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/4/30
*/

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MyRule {

    @Bean
    public IRule getiRule(){
        return new RandomRule();
    }
}
