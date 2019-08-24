package com.study.microservice.model;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:shixianqing
 * @Date:2019/1/1613:53
 * @Description:
 **/
@Data
public class User implements Serializable {

    private Integer userId;

    private Date date;
}
