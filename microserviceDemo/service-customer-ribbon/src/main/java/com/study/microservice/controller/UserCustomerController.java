package com.study.microservice.controller;

import com.study.microservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author:shixianqing
 * @Date:2019/1/1619:04
 * @Description:
 **/
@RestController
@RequestMapping(value = "/ribbon/user",produces = {"application/json;charset=utf-8"})
public class UserCustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private LoadBalancerClient loadBalancerClient;

    @GetMapping("/query/{userId}")
    public User getUser(@PathVariable Integer userId){
        ResponseEntity responseEntity  = restTemplate.getForEntity("http://service-provider/user/query/"+userId,User.class,userId);
        return (User) responseEntity.getBody();
    }

    @GetMapping("/query")
    public void query(){
//        ResponseEntity responseEntity = restTemplate.getForEntity("http://SERVICE-PROVIDER/user/query",String.class);
//        System.out.println("SERVICE-PROVIDER----->>"+responseEntity.getBody().toString());
//
//        ResponseEntity responseEntity1 = restTemplate.getForEntity("http://SERVICE-PROVIDER-BAK/user/query",String.class);
//        System.out.println("SERVICE-PROVIDER-BAK----->>"+responseEntity1.getBody().toString());

        String u1 = loadBalancerClient.choose("SERVICE-PROVIDER").getUri().toString();
        String u2 = loadBalancerClient.choose("SERVICE-PROVIDER-BAK").getUri().toString();

        System.out.println("SERVICE-PROVIDER------>>>>"+u1);
        System.out.println("SERVICE-PROVIDER-BAK------>>>>"+u2);
    }

    @GetMapping("/test")
    public String test(){
        return "test";
    }
}
