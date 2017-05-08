package com.mall.mapper;

import com.mall.model.TTopup;
import com.mall.model.TTopupExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTopupMapper {
    int countByExample(TTopupExample example);

    int deleteByExample(TTopupExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTopup record);

    int insertSelective(TTopup record);

    List<TTopup> selectByExample(TTopupExample example);

    TTopup selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTopup record, @Param("example") TTopupExample example);

    int updateByExample(@Param("record") TTopup record, @Param("example") TTopupExample example);

    int updateByPrimaryKeySelective(TTopup record);

    int updateByPrimaryKey(TTopup record);
}