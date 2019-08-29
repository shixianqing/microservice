package com.study.microservice.command;

import com.netflix.hystrix.HystrixCommand;
import com.netflix.hystrix.HystrixCommandGroupKey;
import com.netflix.hystrix.HystrixCommandKey;
import com.study.microservice.ServiceHystrixApplication;
import com.study.microservice.model.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.context.ApplicationContext;
import org.springframework.web.client.RestTemplate;

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
 * @Date:2019/8/29 17:29
 * @Description: hystrix命令模式，可以对请求再次封装，使其具有熔断、服务降级等能力
 **/
@Slf4j
public class UserCommand extends HystrixCommand<User> {


    private static final String URL = "http://service-provider/user/query/1";

    public UserCommand() {
        super(Setter.withGroupKey(HystrixCommandGroupKey.Factory.asKey("userGroupKey"))
        .andCommandKey(HystrixCommandKey.Factory.asKey("userKey")));
    }

    @Override
    protected User run() throws Exception {
        log.info("{}，进入到-------------》》run ",Thread.currentThread().getName());
        ApplicationContext applicationContext = ServiceHystrixApplication.getApplicationContext();
        RestTemplate restTemplate = applicationContext.getBean(RestTemplate.class);
        User user = restTemplate.getForObject(URL, User.class);
        log.info("查询到的结果：{}",user);
        return user;
    }


    @Override
    protected User getFallback() {
        log.error("进入异常回退.......");
        return new User();
    }

}
