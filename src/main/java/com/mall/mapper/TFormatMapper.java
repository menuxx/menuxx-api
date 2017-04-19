package com.mall.mapper;

import com.mall.model.TFormat;
import com.mall.model.TFormatExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TFormatMapper {
    int countByExample(TFormatExample example);

    int deleteByExample(TFormatExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TFormat record);

    int insertSelective(TFormat record);

    List<TFormat> selectByExample(TFormatExample example);

    TFormat selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TFormat record, @Param("example") TFormatExample example);

    int updateByExample(@Param("record") TFormat record, @Param("example") TFormatExample example);

    int updateByPrimaryKeySelective(TFormat record);

    int updateByPrimaryKey(TFormat record);
}