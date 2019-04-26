package com.shemuel.controller;

import com.shemuel.model.VisitLog;
import com.shemuel.service.VisitLogService;
import com.shemuel.utils.CommonUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;
@RestController
public class TestController {
    @Autowired
    private VisitLogService visitLogService;
    @RequestMapping("/test")
    public VisitLog test () {
        VisitLog visitLog = new VisitLog();
        visitLog.setId(CommonUtils.getUuid());
        visitLog.setAddress("aaa");
        visitLog.setTime(CommonUtils.dateFommat(new Date()));
        return visitLogService.saveVisitLog(visitLog);
    }
}
