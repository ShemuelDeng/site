package com.shemuel.service;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "blog-provider-test")
public interface CommonConsumerService {
    @PostMapping("/insert")
    String insert(@RequestParam("tableName") String tableName, @RequestBody String params);
    @PostMapping("/query")
    String query(@RequestParam("tableName") String tableName,@RequestBody String params);
}
