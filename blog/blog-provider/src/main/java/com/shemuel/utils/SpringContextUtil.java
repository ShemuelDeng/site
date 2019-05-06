package com.shemuel.utils;


import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;

@Component
public class SpringContextUtil implements ApplicationContextAware {
    private static ApplicationContext applicationContext;

    public void setApplicationContext(ApplicationContext applicationContext) throws BeansException {
        SpringContextUtil.applicationContext = applicationContext;
    }

    public ApplicationContext getApplicationContext () {
        return applicationContext;
    }
    public static Object getContextMapper (String tableName) throws BeansException,ClassNotFoundException {
        if (CommonUtils.isEmptyString(tableName)) {
            return null;
        }
        Class clazz = Class.forName("com.shemuel.dao." + tableName.toUpperCase() + "Mapper");;
        Object object  = applicationContext.getBean(clazz);;
        return object;
    }

    public static Class<?> getBeanClass(String tableName) throws ClassNotFoundException{
        return Class.forName("com.shemuel.model." + tableName);
    }
}
