package com.study.microservice;

import com.study.CustomerRandomRuleConfig;
import com.study.CustomerRoundRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.cloud.netflix.ribbon.RibbonClients;

/**
 * @Author:shixianqing
 * @Date:2019/1/1619:03
 * @Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClients(value = {
            @RibbonClient(name = "SERVICE-PROVIDER", configuration = CustomerRandomRuleConfig.class),//自定义负载均衡算法
            @RibbonClient(name = "SERVICE-PROVIDER-BAK",configuration = CustomerRoundRuleConfig.class)
            }) //开启对service-provider服务的负载均衡
public class ServiceCusomerRibbonApplication {

    public static void main(String[] args) {
        SpringApplication.run(ServiceCusomerRibbonApplication.class);
    }
}
