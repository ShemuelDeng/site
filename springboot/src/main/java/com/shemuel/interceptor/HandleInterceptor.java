package com.shemuel.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shemuel.domain.Address;
import com.shemuel.util.WebUtil;
import eu.bitwalker.useragentutils.UserAgent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

@Component
public class HandleInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private RestTemplate restTemplate;
    // 请求前置事件
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();//获得客户端发送请求的完整url
//        String ip = WebUtil.getClientIP(request);//返回发出请求的IP地址
        String ip = "221.123.191.228";
        try {
            String ipAddress = restTemplate.getForObject("http://ip.taobao.com/service/getIpInfo.php?ip={ip}", String.class, "");
            Address address = JSON.parseObject(JSON.parseObject(ipAddress, Map.class).get("data").toString(), Address.class);
            System.out.println(address);
        } catch (Exception e) {
            if (e instanceof  HttpClientErrorException) {
                System.out.println("请求出错");
            }
            e.printStackTrace();
        }
        UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
        System.out.println(userAgent.getBrowser());
        System.out.println(userAgent.getOperatingSystem());
        System.out.println(url);
        System.out.println(ip);
        System.out.println(request.getLocalName());
        return true;
    }
}
