package com.mall.mapper;

import com.mall.model.TRechargeRecord;
import com.mall.model.TRechargeRecordExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TRechargeRecordMapper {
    int countByExample(TRechargeRecordExample example);

    int deleteByExample(TRechargeRecordExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TRechargeRecord record);

    int insertSelective(TRechargeRecord record);

    List<TRechargeRecord> selectByExample(TRechargeRecordExample example);

    TRechargeRecord selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TRechargeRecord record, @Param("example") TRechargeRecordExample example);

    int updateByExample(@Param("record") TRechargeRecord record, @Param("example") TRechargeRecordExample example);

    int updateByPrimaryKeySelective(TRechargeRecord record);

    int updateByPrimaryKey(TRechargeRecord record);
}