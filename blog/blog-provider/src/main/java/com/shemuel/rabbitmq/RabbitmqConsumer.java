package com.shemuel.rabbitmq;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shemuel.model.Address;
import com.shemuel.service.CommonService;
import com.shemuel.service.MailService;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import java.util.Map;

/**
 * @Author: dengshaoxiang
 * @Date: 2019/6/10 11:03
 * @Description:
 */
@Component
public class RabbitmqConsumer {
    private CommonService commonService;
    private MailService mailService;
    private RestTemplate restTemplate;
    public RabbitmqConsumer(CommonService commonService,MailService mailService,RestTemplate restTemplate) {
        this.mailService = mailService;
        this.commonService = commonService;
        this.restTemplate = restTemplate;
    }

    @RabbitListener(queues="shemuel.log.test")
    public void recieveMessages(String map) {
        System.out.println("接收消息...");
        @SuppressWarnings(value = "unchecked")
        Map<String,String> msgMap = JSONObject.parseObject(map, Map.class);
        Address address = null;
        try {
            String ipAddress = restTemplate.getForObject("http://ip.taobao.com/service/getIpInfo.php?ip={ip}", String.class, "124.127.129.146");
            if (StringUtils.isEmpty(ipAddress)){
                address = new Address();
                address.setRegion("region query failed");
            } else {
                address = JSON.parseObject(JSON.parseObject(ipAddress, Map.class).get("data").toString(), Address.class);
            }
        } catch (Exception e) {
            address = new Address();
            if (e instanceof  HttpClientErrorException) {
                address.setRegion("region query failed");
            }
            e.printStackTrace();
        }
        msgMap.put("address",address.toString());
        commonService.insert("visit_log",JSONObject.toJSONString(msgMap));
    }
    @RabbitListener(queues="shemuel.mail")
    public void recieveMailMsg(String message) {
        try {
            mailService.sendMail(message);
        } catch (Exception e){
            e.printStackTrace();
        }
    }
}
