package com.study;

import com.netflix.client.config.IClientConfig;
import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import com.netflix.loadbalancer.RoundRobinRule;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author:shixianqing
 * @Date:2019/1/1718:14
 * @Description: 重写负载均衡算法
 **/
@Configuration
public class CustomerRoundRuleConfig {

    @Autowired
    private IClientConfig clientConfig;

    @Bean
    public IRule ribbonRule(IClientConfig config) {

        return new RoundRobinRule();//轮询算法
    }
}
