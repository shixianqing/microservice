package com.study.microservice.controller;

import com.study.microservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.Random;

/**
 * @Author:shixianqing
 * @Date:2019/1/1613:51
 * @Description:
 **/
@RestController
@RequestMapping(value = "/user", produces = {"application/json;charset=utf-8"})
public class UserController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/query/{id}")
    public User getUser(@PathVariable("id") Integer userId) throws InterruptedException {
        int sleepTime = new Random().nextInt(3000);
        Thread.sleep(sleepTime);
        User user = new User();
        user.setUserId(userId);
        user.setDate(new Date());
        return user;
    }

    @GetMapping("/query")
    public String query() {
        ServiceInstance serviceInstance = discoveryClient.getInstances("service-provider").get(0);
        return serviceInstance.getUri().toString();
    }
}
