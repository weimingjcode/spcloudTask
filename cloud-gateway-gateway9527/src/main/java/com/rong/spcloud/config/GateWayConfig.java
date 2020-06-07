package com.rong.spcloud.config;/*
 @author jm
 @DESCRIPTION ${DESCRIPTION}
 @create 2020/6/5
*/

import com.rong.spcloud.GateWayMain9527;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.ZonedDateTime;

@Configuration

public class GateWayConfig {
    @Bean
    public RouteLocator customerRoutLocator(RouteLocatorBuilder routeLocatorBuilder){
        RouteLocatorBuilder.Builder routes = routeLocatorBuilder.routes();

        routes.route("path_rout_testbaidu",
                    r -> r.path("/guonei")
                    .uri("http://news.baidu.com")).build();
        return routes.build();
    }

    public static void main(String[] args) {
        ZonedDateTime zonedDateTime = ZonedDateTime.now();
        System.out.println(zonedDateTime.toString());
    }
}
