package com.mall.mapper;

import com.mall.model.TPushKey;
import com.mall.model.TPushKeyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TPushKeyMapper {
    int countByExample(TPushKeyExample example);

    int deleteByExample(TPushKeyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TPushKey record);

    int insertSelective(TPushKey record);

    List<TPushKey> selectByExample(TPushKeyExample example);

    TPushKey selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TPushKey record, @Param("example") TPushKeyExample example);

    int updateByExample(@Param("record") TPushKey record, @Param("example") TPushKeyExample example);

    int updateByPrimaryKeySelective(TPushKey record);

    int updateByPrimaryKey(TPushKey record);
}