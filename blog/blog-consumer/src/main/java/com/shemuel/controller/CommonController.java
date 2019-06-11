package com.shemuel.controller;

import com.shemuel.model.Constant;
import com.shemuel.service.CommonConsumerService;
import com.shemuel.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@EnableCircuitBreaker
@RestController
@RequestMapping("/consumer")
public class CommonController {
    @Autowired
    private CommonConsumerService consuerService;
    @PostMapping("/insert/{tableName}")
    public Map insert(@PathVariable String tableName,@RequestBody String json) {
        try {
            return WebUtil.responseMap(Constant.SUCCESS, 1, consuerService.insert(tableName,json));
        } catch (Exception e) {
            e.printStackTrace();
            return WebUtil.responseMap(Constant.FAILED, 0 ,e.getMessage());
        }
    }
    @PostMapping("/query/{tableName}")
    public Map query(@PathVariable String tableName, @RequestParam(value ="paramsJson",required = false) String paramsJson) {
        try {
            return WebUtil.responseMap(Constant.SUCCESS, 1, consuerService.query(tableName,paramsJson));
        } catch (Exception e) {
            e.printStackTrace();
            return WebUtil.responseMap(Constant.FAILED, 0 ,e.getMessage());
        }
    }
    @PostMapping("/delete/{tableName}")
    public Map delete(@PathVariable String tableName, @RequestParam(value ="ids") String ids) {
        try {
            return WebUtil.responseMap(Constant.SUCCESS, 1, consuerService.delete(tableName,ids));
        } catch (Exception e) {
            e.printStackTrace();
            return WebUtil.responseMap(Constant.FAILED, 0 ,e.getMessage());
        }
    }
}
