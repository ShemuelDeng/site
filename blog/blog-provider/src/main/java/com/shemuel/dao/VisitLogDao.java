package com.shemuel.dao;

import com.shemuel.model.VisitLog;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VisitLogDao extends JpaRepository<VisitLog, Integer> {
}
