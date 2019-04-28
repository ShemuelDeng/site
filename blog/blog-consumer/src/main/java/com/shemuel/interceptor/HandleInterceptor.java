package com.shemuel.interceptor;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.shemuel.model.Address;
import com.shemuel.model.VisitLog;
import com.shemuel.service.VisitLogService;
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
import java.util.Map;

@Component
public class HandleInterceptor extends HandlerInterceptorAdapter {
    @Autowired
    private RestTemplate restTemplate;
    @Autowired
    private VisitLogService visitLogService;
    // 请求前置事件
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String url = request.getRequestURL().toString();//获得客户端发送请求的完整url
//        String ip = WebUtil.getClientIP(request);//返回发出请求的IP地址
        String ip = "58.19.230.67";
        Address address = null;
        try {
            String ipAddress = restTemplate.getForObject("http://ip.taobao.com/service/getIpInfo.php?ip={ip}", String.class, ip);
            address = JSON.parseObject(JSON.parseObject(ipAddress, Map.class).get("data").toString(), Address.class);
        } catch (Exception e) {
            address = new Address();
            address.setIp(ip);
            if (e instanceof  HttpClientErrorException) {
                address.setRegion("region查询失败");
            }
            e.printStackTrace();
        }
        try {
            UserAgent userAgent = UserAgent.parseUserAgentString(request.getHeader("User-Agent"));
            VisitLog visitLog = new VisitLog();
            visitLog.setId(CommonUtils.getUuid());
            visitLog.setAddress(address.toString());
            visitLog.setBrowseType(userAgent.getBrowser().toString());
            visitLog.setOperateSystem(userAgent.getOperatingSystem().toString());
            visitLog.setTime(CommonUtils.dateFommat(new Date()));
            visitLog.setUrl(url);
            visitLog.setComputerName(request.getRemoteHost());
            visitLog.setIp(ip);
            visitLogService.saveVisitLog(visitLog);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }
}
