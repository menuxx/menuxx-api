package com.mall.mapper;

import com.mall.model.TCorpTotal;
import com.mall.model.TCorpTotalExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCorpTotalMapper {
    int countByExample(TCorpTotalExample example);

    int deleteByExample(TCorpTotalExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCorpTotal record);

    int insertSelective(TCorpTotal record);

    List<TCorpTotal> selectByExample(TCorpTotalExample example);

    TCorpTotal selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCorpTotal record, @Param("example") TCorpTotalExample example);

    int updateByExample(@Param("record") TCorpTotal record, @Param("example") TCorpTotalExample example);

    int updateByPrimaryKeySelective(TCorpTotal record);

    int updateByPrimaryKey(TCorpTotal record);
}