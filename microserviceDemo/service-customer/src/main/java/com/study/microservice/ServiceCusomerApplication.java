package com.study.microservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;

/**
 * @Author:shixianqing
 * @Date:2019/1/1619:03
 * @Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
public class ServiceCusomerApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCusomerApplication.class);
    }
}
