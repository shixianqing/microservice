package com.study.microservice.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.study.microservice.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Author:shixianqing
 * @Date:2019/1/1813:51
 * @Description:
 **/
@RestController
@RequestMapping(value = "/hystrix", produces = {"application/json;charset=utf-8"})
public class ServiceHystrixController {

    @Autowired
    private RestTemplate restTemplate;

    @GetMapping("/query/{id}")
    @HystrixCommand(fallbackMethod = "hystrixExceptionDeal")
    public User getUser(@PathVariable Integer id){
        long startTime = System.currentTimeMillis();
        User user = restTemplate.getForObject("http://service-provider/user/query/{1}",User.class,id);
        long endTime = System.currentTimeMillis();
        System.out.println("endTime - startTime ===========  "+(endTime-startTime));
        return user;
    }

    public User hystrixExceptionDeal(Integer id){
        System.out.println("访问出现异常！！！");

        return null;
    }
}
