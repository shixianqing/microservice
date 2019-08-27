package com.study.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;
import org.springframework.cloud.netflix.zuul.filters.discovery.PatternServiceRouteMapper;
import org.springframework.context.annotation.Bean;

/**
 * @Author:shixianqing
 * @Date:2019/1/3110:47
 * @Description:
 **/
@SpringBootApplication
@EnableZuulProxy
@EnableDiscoveryClient
//@EnableCircuitBreaker
public class ZuulApplication {
    public static void main(String[] args) {
        SpringApplication.run(ZuulApplication.class);
    }

    @Bean
    public PatternServiceRouteMapper serviceRouteMapper() {

        /**
         * serviceId的模式为：name-v1
         * 映射到路由模式上为：v1/name/**
         */
        return new PatternServiceRouteMapper(
                "(?<name>^.+)-(?<version>v.+$)",
                "${version}/${name}");
    }
}
