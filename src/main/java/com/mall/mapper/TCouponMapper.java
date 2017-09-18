package com.mall.mapper;

import com.mall.model.TCoupon;
import com.mall.model.TCouponExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TCouponMapper {
    int countByExample(TCouponExample example);

    int deleteByExample(TCouponExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TCoupon record);

    int insertSelective(TCoupon record);

    List<TCoupon> selectByExample(TCouponExample example);

    TCoupon selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TCoupon record, @Param("example") TCouponExample example);

    int updateByExample(@Param("record") TCoupon record, @Param("example") TCouponExample example);

    int updateByPrimaryKeySelective(TCoupon record);

    int updateByPrimaryKey(TCoupon record);
}