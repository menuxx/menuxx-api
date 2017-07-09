package com.mall.mapper;

import com.mall.model.TDadaMerchant;
import com.mall.model.TDadaMerchantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDadaMerchantMapper {
    int countByExample(TDadaMerchantExample example);

    int deleteByExample(TDadaMerchantExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDadaMerchant record);

    int insertSelective(TDadaMerchant record);

    List<TDadaMerchant> selectByExample(TDadaMerchantExample example);

    TDadaMerchant selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDadaMerchant record, @Param("example") TDadaMerchantExample example);

    int updateByExample(@Param("record") TDadaMerchant record, @Param("example") TDadaMerchantExample example);

    int updateByPrimaryKeySelective(TDadaMerchant record);

    int updateByPrimaryKey(TDadaMerchant record);
}