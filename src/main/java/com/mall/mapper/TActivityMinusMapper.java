package com.mall.mapper;

import com.mall.model.TActivityMinus;
import com.mall.model.TActivityMinusExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TActivityMinusMapper {
    int countByExample(TActivityMinusExample example);

    int deleteByExample(TActivityMinusExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TActivityMinus record);

    int insertSelective(TActivityMinus record);

    List<TActivityMinus> selectByExample(TActivityMinusExample example);

    TActivityMinus selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TActivityMinus record, @Param("example") TActivityMinusExample example);

    int updateByExample(@Param("record") TActivityMinus record, @Param("example") TActivityMinusExample example);

    int updateByPrimaryKeySelective(TActivityMinus record);

    int updateByPrimaryKey(TActivityMinus record);
}