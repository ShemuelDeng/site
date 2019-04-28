package com.shemuel.service.impl;

import com.shemuel.dao.VisitLogDao;
import com.shemuel.model.VisitLog;
import com.shemuel.service.VisitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class VisitLogServiceImpl implements VisitLogService {
    @Autowired
    private VisitLogDao visitLogDao;
    @PostMapping(value = "saveVisitLog")
    public VisitLog saveVisitLog(@RequestBody VisitLog visitLog) {
        System.out.println(visitLog);
        return visitLogDao.save(visitLog);
    }
    @GetMapping(value = "getVisitLogs")
    public List<VisitLog> getVisitLogs() {
        return visitLogDao.findAll();
    }
}
