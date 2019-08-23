package com.study.microservice.controller;

import com.study.microservice.model.Store;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
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
 * @Date:2019/8/23 14:05
 * @Description:
 **/
@RestController
public class StoreController {

    @RequestMapping(method = RequestMethod.GET, value = "/stores")
    public List<Store> getStores(){
        List<Store> stores = new ArrayList<>();
        for (int i=0 ; i < 5; i++){
            Store store = new Store();
            store.setId(i);
            store.setStoreName("测试"+i);
            stores.add(store);
        }

        return stores;
    }

    @PostMapping(value = "/add",consumes = "application/json")
    public String add(@RequestBody Store store){
        System.out.println(store);

        return "新增成功";
    }

    @GetMapping("/query/{id}")
    public Store queryById(@PathVariable Integer id){
        System.out.println("接收请求id："+id);
        return Store.builder().id(id).storeName("测试").build();
    }
}
