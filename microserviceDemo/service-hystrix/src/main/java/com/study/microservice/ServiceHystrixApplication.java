package com.study.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;

/**
 * @Author:shixianqing
 * @Date:2019/1/1813:42
 * @Description:
 **/
@SpringBootApplication
@EnableCircuitBreaker //开启断路器
@EnableDiscoveryClient //开启服务注册与发现
public class ServiceHystrixApplication {

    private static ApplicationContext applicationContext;
    public static void main(String[] args) {
        ConfigurableApplicationContext context = SpringApplication.run(ServiceHystrixApplication.class);
        setApplicationContext(context);
    }

    public static void setApplicationContext(ApplicationContext applicationContext){
        ServiceHystrixApplication.applicationContext = applicationContext;
    }

    public static ApplicationContext getApplicationContext(){
        return applicationContext;
    }
}
