package com.mall.mapper;

import com.mall.model.TCorpCollect;
import com.mall.model.TCorpCollectExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCorpCollectMapper {
    int countByExample(TCorpCollectExample example);

    int deleteByExample(TCorpCollectExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCorpCollect record);

    int insertSelective(TCorpCollect record);

    List<TCorpCollect> selectByExample(TCorpCollectExample example);

    TCorpCollect selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCorpCollect record, @Param("example") TCorpCollectExample example);

    int updateByExample(@Param("record") TCorpCollect record, @Param("example") TCorpCollectExample example);

    int updateByPrimaryKeySelective(TCorpCollect record);

    int updateByPrimaryKey(TCorpCollect record);
}