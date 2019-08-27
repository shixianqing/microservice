package com.study.microservice.hystrix;

import com.alibaba.fastjson.JSONObject;
import com.netflix.hystrix.exception.HystrixTimeoutException;
import com.study.microservice.response.ResponseVo;
import com.study.microservice.utils.ObjectTranscoder;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.netflix.zuul.filters.route.FallbackProvider;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.stereotype.Component;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.SocketTimeoutException;

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
 * @Date:2019/8/27 11:47
 * @Description: 提供路由熔断支持
 **/
@Component
@Slf4j
public class MyFallbackProvider implements FallbackProvider {

    /**
     * 指定给哪个路由进行熔断回退
     * 可以指定一个路由名，也可以使用ant表达式，比如"*"给所有路由加熔断回退
     * @return
     */
    @Override
    public String getRoute() {
        return "*";
    }

    /**
     * 提供回退响应
     * @param route 路由名称
     * @param cause 异常原因
     * @return
     */
    @Override
    public ClientHttpResponse fallbackResponse(String route, final Throwable cause) {
        log.error("route：{}，错误原因：",route,cause);
        ClientHttpResponse response = new ClientHttpResponse() {
            @Override
            public HttpStatus getStatusCode() throws IOException {
                return HttpStatus.OK;
            }

            @Override
            public int getRawStatusCode() throws IOException {
                return HttpStatus.OK.value();
            }

            @Override
            public String getStatusText() throws IOException {
                return HttpStatus.OK.series().name();
            }

            @Override
            public void close() {

            }

            /**
             * 设置响应体
             * @return
             * @throws IOException
             */
            @Override
            public InputStream getBody() throws IOException {
                ResponseVo responseVo;
                if (cause instanceof HystrixTimeoutException){
                   responseVo = ResponseVo.error(504,"读取超时");
                } else {
                    responseVo = ResponseVo.error();
                }
                String result = JSONObject.toJSONString(responseVo);

                return new ByteArrayInputStream(result.getBytes());
            }

            /**
             * 设置响应头
             * @return
             */
            @Override
            public HttpHeaders getHeaders() {
                HttpHeaders headers = new HttpHeaders();
                headers.add("Content-Type",MediaType.APPLICATION_JSON_UTF8_VALUE);
                return headers;
            }
        };
        return response;
    }
}
