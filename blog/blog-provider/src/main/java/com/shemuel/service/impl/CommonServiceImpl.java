package com.shemuel.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.shemuel.model.CONSTANT;
import com.shemuel.model.PageResult;
import com.shemuel.service.CommonService;
import com.shemuel.utils.CommonUtils;
import com.shemuel.utils.ExampleUtils;
import com.shemuel.utils.SpringContextUtil;
import org.springframework.web.bind.annotation.*;
import java.lang.reflect.Method;
import java.util.Map;


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
        } catch (Exception e) {
            e.printStackTrace();
            if (e instanceof ClassNotFoundException){
                return CONSTANT.TABLE_NOT_FOUND;
            }
        }
        return CONSTANT.INSERT_FAILED;
    }

    @PostMapping("/query")
    public String query(@RequestParam String tableName, @RequestParam(value = "params",required = false) String params) {
        tableName = tableName.toUpperCase();
        Map<String,Object> paramMap = JSONObject.parseObject("".equals(params)?null:params,Map.class);
        Integer pageNum = 1, pageSize = 4;
        if (paramMap != null) {
            pageNum = paramMap.get("pageNum") == null ? 1 : (Integer) paramMap.get("pageNum");
            pageSize = paramMap.get("pageSize") == null ? 4 : (Integer) paramMap.get("pageSize");
        }
        try {
            Object mapper = SpringContextUtil.getContextMapper(tableName);
            Object example = ExampleUtils.getSelectExample(tableName, paramMap);
            Method selectByExample = mapper.getClass().getDeclaredMethod("selectByExample",example.getClass() );
            PageHelper.startPage(pageNum,pageSize);
            Page page = (Page)selectByExample.invoke(mapper, example);
            PageResult result = new PageResult(page.getTotal(),page.getResult());
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
