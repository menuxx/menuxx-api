package com.mall.mapper;

import com.mall.model.TActivityNewUser;
import com.mall.model.TActivityNewUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TActivityNewUserMapper {
    int countByExample(TActivityNewUserExample example);

    int deleteByExample(TActivityNewUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TActivityNewUser record);

    int insertSelective(TActivityNewUser record);

    List<TActivityNewUser> selectByExample(TActivityNewUserExample example);

    TActivityNewUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TActivityNewUser record, @Param("example") TActivityNewUserExample example);

    int updateByExample(@Param("record") TActivityNewUser record, @Param("example") TActivityNewUserExample example);

    int updateByPrimaryKeySelective(TActivityNewUser record);

    int updateByPrimaryKey(TActivityNewUser record);
}