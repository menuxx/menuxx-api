package com.mall.mapper;

import com.mall.model.TWXMsg;
import com.mall.model.TWXMsgExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TWXMsgMapper {
    int countByExample(TWXMsgExample example);

    int deleteByExample(TWXMsgExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TWXMsg record);

    int insertSelective(TWXMsg record);

    List<TWXMsg> selectByExample(TWXMsgExample example);

    TWXMsg selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TWXMsg record, @Param("example") TWXMsgExample example);

    int updateByExample(@Param("record") TWXMsg record, @Param("example") TWXMsgExample example);

    int updateByPrimaryKeySelective(TWXMsg record);

    int updateByPrimaryKey(TWXMsg record);
}