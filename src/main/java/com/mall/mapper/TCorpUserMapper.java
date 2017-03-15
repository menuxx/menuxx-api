package com.mall.mapper;

import com.mall.model.TCorpUser;
import com.mall.model.TCorpUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCorpUserMapper {
    int countByExample(TCorpUserExample example);

    int deleteByExample(TCorpUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCorpUser record);

    int insertSelective(TCorpUser record);

    List<TCorpUser> selectByExample(TCorpUserExample example);

    TCorpUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCorpUser record, @Param("example") TCorpUserExample example);

    int updateByExample(@Param("record") TCorpUser record, @Param("example") TCorpUserExample example);

    int updateByPrimaryKeySelective(TCorpUser record);

    int updateByPrimaryKey(TCorpUser record);
}