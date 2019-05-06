package com.shemuel.utils;

import com.alibaba.fastjson.JSONObject;
import com.shemuel.model.CONSTANT;

import java.lang.reflect.Method;
import java.util.Map;

public class ExampleUtils {
    public static Object getSelectExample(String tableName, String paramsJson){
        Map<String,Object> paramMap = JSONObject.parseObject(paramsJson,Map.class);
        Class<?> exampleClazz ;
//        Class<?> modelClazz ;
        try {
            exampleClazz = SpringContextUtil.getBeanClass(tableName + "Example");
//            modelClazz = SpringContextUtil.getBeanClass(tableName);
            Object exampleObject = exampleClazz.newInstance();
            Method createCriteria = exampleClazz.getDeclaredMethod("createCriteria");
            Object criteria = createCriteria.invoke(exampleObject);
            Class<?> criteriaClazz = criteria.getClass();
//            Field[] modelFields = modelClazz.getDeclaredFields();
//            for (Field field: modelFields) {
//                String fieldName = field.getName();
//                Class<?> fieldClazz = field.getClass();
//                if (String.class.equals(fieldClazz)) { // 字符串
//
//                } else if (Integer.class.equals(fieldClazz)){ // int 类型的
//
//                } else if (Date.class.equals(fieldClazz)) { // 日期类型
//
//                }
//            }
            for (Map.Entry<String,Object> entry:paramMap.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue().toString();
                Method keyEqualTO = criteriaClazz.getDeclaredMethod("and" + CommonUtils.upperFirstWord(key) + "Like", String.class);
                keyEqualTO.invoke(criteria, CONSTANT.PERCENT + value +CONSTANT.PERCENT);
            }
            return exampleObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
