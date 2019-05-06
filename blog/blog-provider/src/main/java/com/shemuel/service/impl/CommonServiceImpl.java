package com.shemuel.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.shemuel.model.ARTICLE;
import com.shemuel.model.CONSTANT;
import com.shemuel.model.MESSAGEExample;
import com.shemuel.service.CommonService;
import com.shemuel.utils.CommonUtils;
import com.shemuel.utils.ExampleUtils;
import com.shemuel.utils.SpringContextUtil;
import org.springframework.web.bind.annotation.*;


import javax.swing.*;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.sql.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
public class CommonServiceImpl implements CommonService {
    @PostMapping("/insert")
    public String insert(@RequestParam("tableName") String tableName, @RequestBody String beanJson) {
        tableName = tableName.toUpperCase();
        try {
            Class beanClazz = SpringContextUtil.getBeanClass(tableName);
            Object object = JSONObject.parseObject(beanJson, beanClazz);
            Object mapper = SpringContextUtil.getContextMapper(tableName);
            Method setId = beanClazz.getDeclaredMethod("setId", String.class);
            setId.invoke(object, CommonUtils.getUuid());
            int result = (Integer) mapper.getClass().getDeclaredMethod("insert",beanClazz).invoke(mapper,object);
            if (result == 1) {
                return JSONObject.toJSONString(object);
            }
            return CONSTANT.INSERT_FAILED;
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof ClassNotFoundException){
                return CONSTANT.TABLE_NOT_FOUND;
            }
            return CONSTANT.INSERT_FAILED;
        }
    }

    @PostMapping("/query")
    public String query(@RequestParam String tableName, @RequestBody String paramsJson) {
        tableName = tableName.toUpperCase();
        try {
            Object mapper = SpringContextUtil.getContextMapper(tableName);
            Object example = ExampleUtils.getSelectExample(tableName, paramsJson);
            Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample",example.getClass() );
            List result = (List)selectByExample.invoke(mapper, example);
            return JSONObject.toJSONString(result);
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof ClassNotFoundException){
                return CONSTANT.TABLE_NOT_FOUND;
            }
        }
        return CONSTANT.QUERY_FAILED;
    }
}
