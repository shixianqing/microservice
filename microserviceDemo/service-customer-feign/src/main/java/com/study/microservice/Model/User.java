package com.study.microservice.Model;

import lombok.Data;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * @Author:shixianqing
 * @Date:2019/1/1613:53
 * @Description:
 **/
@Data
@ToString
public class User implements Serializable {

    private Integer userId;

    private Date date;
}
