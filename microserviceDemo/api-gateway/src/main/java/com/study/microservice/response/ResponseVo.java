package com.study.microservice.response;

import java.io.Serializable;
import java.util.HashMap;

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
 * @Date:2019/8/27 11:42
 * @Description:
 **/
public class ResponseVo extends HashMap implements Serializable {

    private static final Integer SUCCESS_CODE = 200;

    private static final String SUCCESS_MSG = "success";

    private static final Integer ERROR_CODE = 500;

    private static final String ERROR_MSG = "error";


    public static ResponseVo success(Integer code ,Object data){
        ResponseVo responseVo = new ResponseVo();
        responseVo.put("code",code);
        responseVo.put("data",data);
        return responseVo;
    }
    public static ResponseVo success(Object data){
        ResponseVo responseVo = new ResponseVo();
        responseVo.put("code",SUCCESS_CODE);
        responseVo.put("data",data);
        return responseVo;
    }
    public static ResponseVo success(){
        ResponseVo responseVo = new ResponseVo();
        responseVo.put("code",SUCCESS_CODE);
        responseVo.put("data",SUCCESS_MSG);
        return responseVo;
    }

    public static ResponseVo error(Integer code ,Object data){
        ResponseVo responseVo = new ResponseVo();
        responseVo.put("code",code);
        responseVo.put("data",data);
        return responseVo;
    }
    public static ResponseVo error(Object data){
        ResponseVo responseVo = new ResponseVo();
        responseVo.put("code",ERROR_CODE);
        responseVo.put("data",data);
        return responseVo;
    }
    public static ResponseVo error(){
        ResponseVo responseVo = new ResponseVo();
        responseVo.put("code",ERROR_CODE);
        responseVo.put("data",ERROR_MSG);
        return responseVo;
    }
}
