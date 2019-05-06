package com.shemuel.dao;

import com.shemuel.model.MESSAGE;
import com.shemuel.model.MESSAGEExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MESSAGEMapper {
    long countByExample(MESSAGEExample example);

    int deleteByExample(MESSAGEExample example);

    int deleteByPrimaryKey(String id);

    int insert(MESSAGE record);

    int insertSelective(MESSAGE record);

    List<MESSAGE> selectByExample(MESSAGEExample example);

    MESSAGE selectByPrimaryKey(String id);

    int updateByExampleSelective(@Param("record") MESSAGE record, @Param("example") MESSAGEExample example);

    int updateByExample(@Param("record") MESSAGE record, @Param("example") MESSAGEExample example);

    int updateByPrimaryKeySelective(MESSAGE record);

    int updateByPrimaryKey(MESSAGE record);
}