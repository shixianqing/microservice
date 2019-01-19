package com.study.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author:shixianqing
 * @Date:2019/1/1813:42
 * @Description:
 **/
@SpringBootApplication
@EnableCircuitBreaker //开启断路器
@EnableDiscoveryClient //开启服务注册与发现
public class ServiceHystrixApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceHystrixApplication.class);
    }
}
