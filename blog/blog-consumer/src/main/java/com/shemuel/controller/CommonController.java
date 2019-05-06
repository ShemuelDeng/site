package com.shemuel.controller;

import com.shemuel.model.CONSTANT;
import com.shemuel.service.CommonConsumerService;
import com.shemuel.utils.WebUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/consumer")
public class CommonController {
    @Autowired
    private CommonConsumerService consuerService;
    @PostMapping("/insert/{tableName}")
    public Map saveArticle(@PathVariable String tableName,@RequestBody String json) {
        try {
            return WebUtil.responseMap(CONSTANT.SUCCESS, 1, consuerService.insert(tableName,json));
        } catch (Exception e) {
            e.printStackTrace();
            return WebUtil.responseMap(CONSTANT.FAILED, 0 ,e.getMessage());
        }
    }
    @PostMapping("/query/{tableName}")
    public Map query(@PathVariable String tableName, @RequestBody String paramsJson) {
        try {
            return WebUtil.responseMap(CONSTANT.SUCCESS, 1, consuerService.query(tableName,paramsJson));
        } catch (Exception e) {
            e.printStackTrace();
            return WebUtil.responseMap(CONSTANT.FAILED, 0 ,e.getMessage());
        }
    }
}
