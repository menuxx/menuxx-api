package com.mall.mapper;

import com.mall.model.TChargeApply;
import com.mall.model.TChargeApplyExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TChargeApplyMapper {
    int countByExample(TChargeApplyExample example);

    int deleteByExample(TChargeApplyExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TChargeApply record);

    int insertSelective(TChargeApply record);

    List<TChargeApply> selectByExample(TChargeApplyExample example);

    TChargeApply selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TChargeApply record, @Param("example") TChargeApplyExample example);

    int updateByExample(@Param("record") TChargeApply record, @Param("example") TChargeApplyExample example);

    int updateByPrimaryKeySelective(TChargeApply record);

    int updateByPrimaryKey(TChargeApply record);
}