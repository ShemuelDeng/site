package com.shemuel.dao;

import com.shemuel.model.ARTICLE;
import com.shemuel.model.ARTICLEExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ARTICLEMapper {
    long countByExample(ARTICLEExample example);

    int deleteByExample(ARTICLEExample example);

    int deleteByPrimaryKey(String id);

    int insert(ARTICLE record);

    int insertSelective(ARTICLE record);

    List<ARTICLE> selectByExample(ARTICLEExample example);

    ARTICLE selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") ARTICLE record, @Param("example") ARTICLEExample example);

    int updateByExample(@Param("record") ARTICLE record, @Param("example") ARTICLEExample example);

    int updateByPrimaryKeySelective(ARTICLE record);

    int updateByPrimaryKey(ARTICLE record);
}