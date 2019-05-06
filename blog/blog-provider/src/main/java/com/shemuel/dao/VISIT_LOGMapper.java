package com.shemuel.dao;

import com.shemuel.model.VISIT_LOG;
import com.shemuel.model.VISIT_LOGExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

public interface VISIT_LOGMapper {
    long countByExample(VISIT_LOGExample example);

    int deleteByExample(VISIT_LOGExample example);

    int deleteByPrimaryKey(String id);

    int insert(VISIT_LOG record);

    int insertSelective(VISIT_LOG record);

    List<VISIT_LOG> selectByExample(VISIT_LOGExample example);

    VISIT_LOG selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") VISIT_LOG record, @Param("example") VISIT_LOGExample example);

    int updateByExample(@Param("record") VISIT_LOG record, @Param("example") VISIT_LOGExample example);

    int updateByPrimaryKeySelective(VISIT_LOG record);

    int updateByPrimaryKey(VISIT_LOG record);
}