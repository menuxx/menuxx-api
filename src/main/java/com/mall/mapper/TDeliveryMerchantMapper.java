package com.mall.mapper;

import com.mall.model.TDeliveryMerchant;
import com.mall.model.TDeliveryMerchantExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDeliveryMerchantMapper {
    int countByExample(TDeliveryMerchantExample example);

    int deleteByExample(TDeliveryMerchantExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDeliveryMerchant record);

    int insertSelective(TDeliveryMerchant record);

    List<TDeliveryMerchant> selectByExample(TDeliveryMerchantExample example);

    TDeliveryMerchant selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDeliveryMerchant record, @Param("example") TDeliveryMerchantExample example);

    int updateByExample(@Param("record") TDeliveryMerchant record, @Param("example") TDeliveryMerchantExample example);

    int updateByPrimaryKeySelective(TDeliveryMerchant record);

    int updateByPrimaryKey(TDeliveryMerchant record);
}