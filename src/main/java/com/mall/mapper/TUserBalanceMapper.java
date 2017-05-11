package com.mall.mapper;

import com.mall.model.TUserBalance;
import com.mall.model.TUserBalanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TUserBalanceMapper {
    int countByExample(TUserBalanceExample example);

    int deleteByExample(TUserBalanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TUserBalance record);

    int insertSelective(TUserBalance record);

    List<TUserBalance> selectByExample(TUserBalanceExample example);

    TUserBalance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TUserBalance record, @Param("example") TUserBalanceExample example);

    int updateByExample(@Param("record") TUserBalance record, @Param("example") TUserBalanceExample example);

    int updateByPrimaryKeySelective(TUserBalance record);

    int updateByPrimaryKey(TUserBalance record);
}