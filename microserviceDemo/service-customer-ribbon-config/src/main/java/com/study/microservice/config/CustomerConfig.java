package com.study.microservice.config;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

/**
 * @Author:shixianqing
 * @Date:2019/1/1619:11
 * @Description:
 **/
@Configuration
public class CustomerConfig {

    /**
     * @LoadBalanced 开启客户端负载均衡
     * @return
     */
    @Bean
    @LoadBalanced
    public RestTemplate getRestTemplate(){

        return new RestTemplate();
    }
}
