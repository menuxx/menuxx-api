package com.mall.mapper;

import com.mall.model.TCouponConfig;
import com.mall.model.TCouponConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCouponConfigMapper {
    int countByExample(TCouponConfigExample example);

    int deleteByExample(TCouponConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCouponConfig record);

    int insertSelective(TCouponConfig record);

    List<TCouponConfig> selectByExample(TCouponConfigExample example);

    TCouponConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCouponConfig record, @Param("example") TCouponConfigExample example);

    int updateByExample(@Param("record") TCouponConfig record, @Param("example") TCouponConfigExample example);

    int updateByPrimaryKeySelective(TCouponConfig record);

    int updateByPrimaryKey(TCouponConfig record);
}