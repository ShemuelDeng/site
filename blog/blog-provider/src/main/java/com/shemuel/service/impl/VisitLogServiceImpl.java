package com.shemuel.service.impl;

import com.shemuel.dao.VisitLogDao;
import com.shemuel.model.VisitLog;
import com.shemuel.service.VisitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class VisitLogServiceImpl implements VisitLogService {
    @Autowired
    private VisitLogDao visitLogDao;
    public VisitLog saveVisitLog(VisitLog visitLog) {
        return visitLogDao.save(visitLog);
    }
}
