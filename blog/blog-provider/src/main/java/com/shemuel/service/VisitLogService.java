package com.shemuel.service;

import com.shemuel.model.VisitLog;

import java.util.List;

public interface VisitLogService {
    VisitLog saveVisitLog(VisitLog visitLog);
    List<VisitLog> getVisitLogs ();
}
