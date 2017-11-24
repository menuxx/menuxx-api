package com.mall.mapper;

import com.mall.model.TDeliveryOrder;
import com.mall.model.TDeliveryOrderExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDeliveryOrderMapper {
    int countByExample(TDeliveryOrderExample example);

    int deleteByExample(TDeliveryOrderExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDeliveryOrder record);

    int insertSelective(TDeliveryOrder record);

    List<TDeliveryOrder> selectByExample(TDeliveryOrderExample example);

    TDeliveryOrder selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDeliveryOrder record, @Param("example") TDeliveryOrderExample example);

    int updateByExample(@Param("record") TDeliveryOrder record, @Param("example") TDeliveryOrderExample example);

    int updateByPrimaryKeySelective(TDeliveryOrder record);

    int updateByPrimaryKey(TDeliveryOrder record);
}