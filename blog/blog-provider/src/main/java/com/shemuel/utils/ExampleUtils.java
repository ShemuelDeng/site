package com.shemuel.utils;

import com.shemuel.model.Constant;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Date;
import java.util.Map;

public class ExampleUtils {
    public static Object getSelectExample(String tableName, Map<String,Object> paramMap){
        Class<?> exampleClazz ;
        Class<?> modelClazz ;
        try {
            exampleClazz = SpringContextUtil.getBeanClass(tableName + "Example");
            modelClazz = SpringContextUtil.getBeanClass(tableName);
            Object exampleObject = exampleClazz.newInstance();
            Method createCriteria = exampleClazz.getDeclaredMethod("createCriteria");
            Object criteria = createCriteria.invoke(exampleObject);
            Class<?> criteriaClazz = criteria.getClass();
            Field[] modelFields = modelClazz.getDeclaredFields();
            if (paramMap == null) {
                return exampleObject;
            }
            for (Field field: modelFields) {
                String fieldName = field.getName();
                Class<?> fieldClazz = field.getType();
                if (paramMap.get(fieldName) == null) {
                    continue;
                }
                if (String.class.equals(fieldClazz)) { // 字符串
                    Method keyEqualTO = criteriaClazz.getDeclaredMethod("and" + CommonUtils.upperFirstWord(fieldName) + "Like", String.class);
                    keyEqualTO.invoke(criteria, Constant.PERCENT + paramMap.get(fieldName).toString() + Constant.PERCENT);
                } else if (Integer.class.equals(fieldClazz)){ // int 类型的
                    Method keyEqualTO = criteriaClazz.getDeclaredMethod("and" + CommonUtils.upperFirstWord(fieldName) + "EqualTo", Integer.class);
                    keyEqualTO.invoke(criteria, (Integer)paramMap.get(fieldName));
                } else if (Date.class.equals(fieldClazz)) { // 日期类型
                   /* Method keyEqualTO = criteriaClazz.getDeclaredMethod("and" + CommonUtils.upperFirstWord(fieldName) + "EqualTo", Integer.class);
                    keyEqualTO.invoke(criteria, paramMap.get(fieldName));*/
                }
            }
/*            for (Map.Entry<String,Object> entry:paramMap.entrySet()){
                String key = entry.getKey();
                String value = entry.getValue().toString();
                Method keyEqualTO = criteriaClazz.getDeclaredMethod("and" + CommonUtils.upperFirstWord(key) + "Like", String.class);
                keyEqualTO.invoke(criteria, Constant.PERCENT + value +Constant.PERCENT);
            }*/
            return exampleObject;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}
