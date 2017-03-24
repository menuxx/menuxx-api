package com.mall.mapper;

import com.mall.model.TCorpDiscover;
import com.mall.model.TCorpDiscoverExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCorpDiscoverMapper {
    int countByExample(TCorpDiscoverExample example);

    int deleteByExample(TCorpDiscoverExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCorpDiscover record);

    int insertSelective(TCorpDiscover record);

    List<TCorpDiscover> selectByExample(TCorpDiscoverExample example);

    TCorpDiscover selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCorpDiscover record, @Param("example") TCorpDiscoverExample example);

    int updateByExample(@Param("record") TCorpDiscover record, @Param("example") TCorpDiscoverExample example);

    int updateByPrimaryKeySelective(TCorpDiscover record);

    int updateByPrimaryKey(TCorpDiscover record);
}