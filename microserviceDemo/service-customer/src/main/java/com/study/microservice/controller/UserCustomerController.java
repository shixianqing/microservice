package com.study.microservice.controller;

import com.study.microservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
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
@RequestMapping(value = "/customer/user",produces = {"application/json;charset=utf-8"})
public class UserCustomerController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/query/{userId}")
    public User getUser(@PathVariable Integer userId){
//        ResponseEntity responseEntity  = restTemplate.getForEntity("http://service-provider/user/query/"+userId,User.class,userId);
//        return (User) responseEntity.getBody();
        return restTemplate.getForObject("http://service-provider/user/query/{1}",User.class,userId);
    }

    @GetMapping("/query")
    public String query(){
        ResponseEntity responseEntity = restTemplate.getForEntity("http://service-provider/user/query",String.class);
        return responseEntity.getBody().toString();
    }
}
