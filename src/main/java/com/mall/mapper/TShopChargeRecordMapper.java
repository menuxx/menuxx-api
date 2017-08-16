package com.mall.mapper;

import com.mall.model.TShopChargeRecord;
import com.mall.model.TShopChargeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TShopChargeRecordMapper {
    int countByExample(TShopChargeRecordExample example);

    int deleteByExample(TShopChargeRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TShopChargeRecord record);

    int insertSelective(TShopChargeRecord record);

    List<TShopChargeRecord> selectByExample(TShopChargeRecordExample example);

    TShopChargeRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TShopChargeRecord record, @Param("example") TShopChargeRecordExample example);

    int updateByExample(@Param("record") TShopChargeRecord record, @Param("example") TShopChargeRecordExample example);

    int updateByPrimaryKeySelective(TShopChargeRecord record);

    int updateByPrimaryKey(TShopChargeRecord record);
}