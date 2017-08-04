package com.mall.mapper;

import com.mall.model.TDeliveryShop;
import com.mall.model.TDeliveryShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDeliveryShopMapper {
    int countByExample(TDeliveryShopExample example);

    int deleteByExample(TDeliveryShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDeliveryShop record);

    int insertSelective(TDeliveryShop record);

    List<TDeliveryShop> selectByExample(TDeliveryShopExample example);

    TDeliveryShop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDeliveryShop record, @Param("example") TDeliveryShopExample example);

    int updateByExample(@Param("record") TDeliveryShop record, @Param("example") TDeliveryShopExample example);

    int updateByPrimaryKeySelective(TDeliveryShop record);

    int updateByPrimaryKey(TDeliveryShop record);
}