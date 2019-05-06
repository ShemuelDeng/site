package com.shemuel.service;
public interface CommonService {
    String insert(String tableName, String beanJson);
    String query(String tableName, String paramsJson);
}
