package com.mall.mapper;

import com.mall.model.TShopBusinessTime;
import com.mall.model.TShopBusinessTimeExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TShopBusinessTimeMapper {
    int countByExample(TShopBusinessTimeExample example);

    int deleteByExample(TShopBusinessTimeExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TShopBusinessTime record);

    int insertSelective(TShopBusinessTime record);

    List<TShopBusinessTime> selectByExample(TShopBusinessTimeExample example);

    TShopBusinessTime selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TShopBusinessTime record, @Param("example") TShopBusinessTimeExample example);

    int updateByExample(@Param("record") TShopBusinessTime record, @Param("example") TShopBusinessTimeExample example);

    int updateByPrimaryKeySelective(TShopBusinessTime record);

    int updateByPrimaryKey(TShopBusinessTime record);
}