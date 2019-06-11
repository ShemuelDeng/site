package com.shemuel.controller;

import com.alibaba.fastjson.JSONObject;
import com.shemuel.model.Constant;
import com.shemuel.utils.WebUtil;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

/**
 * @Author: dengshaoxiang
 * @Date: 2019/6/10 15:03
 * @Description:
 */
@ControllerAdvice
public class ExceptionController {
    @Autowired
    private RabbitTemplate rabbitTemplate;
    @ExceptionHandler
    @ResponseBody
    public Map<String, Object> handleException(Exception e) {
        rabbitTemplate.convertAndSend("amq.direct","shemuel.mail", e.getMessage());
        System.out.println("异常信息已通知管理员....");
        return WebUtil.responseMap("服务器发生异常!异常信息已通知管理员,会尽快处理!",0,e.getMessage());
    }
}
