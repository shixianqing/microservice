package com.study;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:shixianqing
 * @Date:2019/1/1718:14
 * @Description: 重写负载均衡算法
 * 自定义负载均衡算法配置类，不能放在能被componentScan注解扫描到的位置
 * 如果非要放到与启动类在一起的包下，则需要在启动类上过滤该配置类
 **/
@Configuration
public class CustomerRandomRuleConfig {

    @Autowired
    private IClientConfig clientConfig;

    @Bean
    public IRule ribbonRule(IClientConfig clientConfig) {

        return new RandomRule();//随机算法
    }
}
