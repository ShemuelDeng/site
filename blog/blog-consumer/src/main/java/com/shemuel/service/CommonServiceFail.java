package com.shemuel.service;

import org.springframework.stereotype.Component;

@Component
public class CommonServiceFail implements CommonConsumerService{
    public String insert(String tableName, String params) {
        return "Sorry, the service is temporarily unavailable,please try again later";
    }

    public String query(String tableName, String params) {
        return "Sorry, the service is temporarily unavailable,please try again later";
    }
}
