package com.mall.mapper;

import com.mall.model.TTable;
import com.mall.model.TTableExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTableMapper {
    int countByExample(TTableExample example);

    int deleteByExample(TTableExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTable record);

    int insertSelective(TTable record);

    List<TTable> selectByExample(TTableExample example);

    TTable selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTable record, @Param("example") TTableExample example);

    int updateByExample(@Param("record") TTable record, @Param("example") TTableExample example);

    int updateByPrimaryKeySelective(TTable record);

    int updateByPrimaryKey(TTable record);
}