package com.study.microservice.controller;

import com.study.microservice.Model.Store;
import com.study.microservice.Model.User;
import com.study.microservice.feign.HystrixClient;
import com.study.microservice.feign.StoreClient;
import com.study.microservice.feign.UserClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.List;

/**
 * *                            _ooOoo_
 * *                           o8888888o
 * *                           88" . "88
 * *                           (| -_- |)
 * *                            O\ = /O
 * *                        ____/`---'\____
 * *                      .   ' \\| |// `.
 * *                       / \\||| : |||// \
 * *                    / _||||| -:- |||||- \
 * *                       | | \\\ - /// | |
 * *                     | \_| ''\---/'' | |
 * *                      \ .-\__ `-` ___/-. /
 * *                   ___`. .' /--.--\ `. . __
 * *                ."" '< `.___\_<|>_/___.' >'"".
 * *               | | : `- \`.;`\ _ /`;.`/ - ` : | |
 * *                 \ \ `-. \_ __\ /__ _/ .-` / /
 * *         ======`-.____`-.___\_____/___.-`____.-'======
 * *                            `=---='
 * *
 * *         .............................................
 * *                  佛祖保佑             永无BUG
 * *          佛曰:
 * *                  写字楼里写字间，写字间里程序员；
 * *                  程序人员写程序，又拿程序换酒钱。
 * *                  酒醒只在网上坐，酒醉还来网下眠；
 * *                  酒醉酒醒日复日，网上网下年复年。
 * *                  但愿老死电脑间，不愿鞠躬老板前；
 * *                  奔驰宝马贵者趣，公交自行程序员。
 * *                  别人笑我忒疯癫，我笑自己命太贱；
 * *                  不见满街漂亮妹，哪个归得程序员？
 *
 * @Author:shixianqing
 * @Date:2019/8/23 15:30
 * @Description:
 **/
@RestController
public class TestFeignController {

    @Autowired
    private StoreClient storeClient;

    @Autowired
    private UserClient userClient;

    @Autowired
    private HystrixClient hystrixClient;

    @GetMapping("/query")
    public List<Store> query(){

        return hystrixClient.getStores();
    }

    @GetMapping("/add")
    public String add(){
        Store store = Store.builder().id(3).storeName("世纪华联").build();
        return storeClient.addStore(store);
    }

    @GetMapping("/query/{id}")
    public Store queryById(@PathVariable Integer id){
        return storeClient.queryById(id);
    }

    @GetMapping("/test")
    public Object test(){
        Store store = Store.builder().id(2).storeName("测试").build();
        return storeClient.query(store);
    }

    @GetMapping("/user/query")
    public User userQuery(){
        User user = new User();
        user.setDate(new Date());
        user.setUserId(2);
        return userClient.getUser(user);
    }
}
