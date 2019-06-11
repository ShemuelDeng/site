package com.shemuel.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(value = "blog-provider-dev", fallback = CommonServiceFail.class)
public interface CommonConsumerService {
    // feign 的接口转发,参数前面不指定@RequestParam或者@RequestBody 则默认为 @RequestBody,
    // 且仅有一个,@RequestParam可以有多个
    // @RequestParam指定的value值必须和blog-provider提供者的一致
    @PostMapping("/insert")
    String insert(@RequestParam("tableName") String tableName, @RequestBody String params);
    @PostMapping("/query")
    String query(@RequestParam("tableName") String tableName,@RequestParam(value = "params",required = false) String params);
    @PostMapping("/delete")
    String delete(@RequestParam("tableName") String tableName,@RequestParam(value = "ids") String ids);
}
