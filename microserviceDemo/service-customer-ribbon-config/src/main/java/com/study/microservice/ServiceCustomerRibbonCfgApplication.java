package com.study.microservice;

import com.study.microservice.annotion.ExcludeComponentScan;
import com.study.microservice.config.CustomerRandomRuleConfig;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

/**
 * @Author:shixianqing
 * @Date:2019/1/1815:26
 * @Description:
 **/
@SpringBootApplication
@EnableDiscoveryClient
@RibbonClient(name = "SERVICE-PROVIDER", configuration = CustomerRandomRuleConfig.class)
@ComponentScan(excludeFilters = {@ComponentScan.Filter(type= FilterType.ANNOTATION,value = ExcludeComponentScan.class)})
public class ServiceCustomerRibbonCfgApplication {
    public static void main(String[] args) {
        SpringApplication.run(ServiceCustomerRibbonCfgApplication.class);
    }
}
