package com.mall.mapper;

import com.mall.model.TShopChargeRecordBalance;
import com.mall.model.TShopChargeRecordBalanceExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TShopChargeRecordBalanceMapper {
    int countByExample(TShopChargeRecordBalanceExample example);

    int deleteByExample(TShopChargeRecordBalanceExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TShopChargeRecordBalance record);

    int insertSelective(TShopChargeRecordBalance record);

    List<TShopChargeRecordBalance> selectByExample(TShopChargeRecordBalanceExample example);

    TShopChargeRecordBalance selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TShopChargeRecordBalance record, @Param("example") TShopChargeRecordBalanceExample example);

    int updateByExample(@Param("record") TShopChargeRecordBalance record, @Param("example") TShopChargeRecordBalanceExample example);

    int updateByPrimaryKeySelective(TShopChargeRecordBalance record);

    int updateByPrimaryKey(TShopChargeRecordBalance record);
}