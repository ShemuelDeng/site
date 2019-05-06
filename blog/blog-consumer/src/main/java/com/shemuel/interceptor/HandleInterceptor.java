package com.shemuel.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shemuel.model.Address;
import com.shemuel.service.CommonConsumerService;
import com.shemuel.utils.CommonUtils;
import com.shemuel.utils.WebUtil;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class HandleInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private CommonConsumerService consuerService;
    // 请求前置事件
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();//获得客户端发送请求的完整url
        String ip = WebUtil.getClientIP(request);//返回发出请求的IP地址
//        String ip = "58.19.230.67";
        Address address ;
        try {
            String ipAddress = restTemplate.getForObject("http://ip.taobao.com/service/getIpInfo.php?ip={ip}", String.class, ip);
            address = JSON.parseObject(JSON.parseObject(ipAddress, Map.class).get("data").toString(), Address.class);
        } catch (Exception e) {
            address = new Address();
            address.setIp(ip);
            if (e instanceof  HttpClientErrorException) {
                address.setRegion("region query failed");
            }
            e.printStackTrace();
        }
        try {
            UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
            Map<String,String> beanMap = new HashMap<String, String>();
            beanMap.put("address",address.toString());
            beanMap.put("browseType",userAgent.getBrowser().toString());
            beanMap.put("operateSystem",userAgent.getOperatingSystem().toString());
            beanMap.put("url",url);
            beanMap.put("ip",ip);
            beanMap.put("computerName",request.getRemoteHost());
            beanMap.put("time",CommonUtils.dateFommat(new Date()));
            consuerService.insert("visit_log", JSONObject.toJSONString(beanMap));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
