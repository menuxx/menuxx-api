package com.mall.mapper;

import com.mall.model.TDeliveryTransport;
import com.mall.model.TDeliveryTransportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TDeliveryTransportMapper {
    int countByExample(TDeliveryTransportExample example);

    int deleteByExample(TDeliveryTransportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TDeliveryTransport record);

    int insertSelective(TDeliveryTransport record);

    List<TDeliveryTransport> selectByExample(TDeliveryTransportExample example);

    TDeliveryTransport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TDeliveryTransport record, @Param("example") TDeliveryTransportExample example);

    int updateByExample(@Param("record") TDeliveryTransport record, @Param("example") TDeliveryTransportExample example);

    int updateByPrimaryKeySelective(TDeliveryTransport record);

    int updateByPrimaryKey(TDeliveryTransport record);
}