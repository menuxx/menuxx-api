package com.mall.mapper;

import com.mall.model.TTakeawayTransport;
import com.mall.model.TTakeawayTransportExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTakeawayTransportMapper {
    int countByExample(TTakeawayTransportExample example);

    int deleteByExample(TTakeawayTransportExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTakeawayTransport record);

    int insertSelective(TTakeawayTransport record);

    List<TTakeawayTransport> selectByExample(TTakeawayTransportExample example);

    TTakeawayTransport selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTakeawayTransport record, @Param("example") TTakeawayTransportExample example);

    int updateByExample(@Param("record") TTakeawayTransport record, @Param("example") TTakeawayTransportExample example);

    int updateByPrimaryKeySelective(TTakeawayTransport record);

    int updateByPrimaryKey(TTakeawayTransport record);
}