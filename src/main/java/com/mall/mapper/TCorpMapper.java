package com.mall.mapper;

import com.mall.model.TCorp;
import com.mall.model.TCorpExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCorpMapper {
    int countByExample(TCorpExample example);

    int deleteByExample(TCorpExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCorp record);

    int insertSelective(TCorp record);

    List<TCorp> selectByExampleWithBLOBs(TCorpExample example);

    List<TCorp> selectByExample(TCorpExample example);

    TCorp selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCorp record, @Param("example") TCorpExample example);

    int updateByExampleWithBLOBs(@Param("record") TCorp record, @Param("example") TCorpExample example);

    int updateByExample(@Param("record") TCorp record, @Param("example") TCorpExample example);

    int updateByPrimaryKeySelective(TCorp record);

    int updateByPrimaryKeyWithBLOBs(TCorp record);

    int updateByPrimaryKey(TCorp record);
}