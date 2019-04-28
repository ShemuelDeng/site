package com.shemuel.service;

import com.shemuel.model.VisitLog;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@FeignClient(value = "blog-provider", path = "")
public interface VisitLogService {
    @GetMapping(value = "/getVisitLogs")
    List<VisitLog> getVisitLogs();
    @PostMapping(value = "saveVisitLog")
    VisitLog saveVisitLog(VisitLog visitLog);
}
