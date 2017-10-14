package com.mall.mapper;

import com.mall.model.TShopConfig;
import com.mall.model.TShopConfigExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TShopConfigMapper {
    int countByExample(TShopConfigExample example);

    int deleteByExample(TShopConfigExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TShopConfig record);

    int insertSelective(TShopConfig record);

    List<TShopConfig> selectByExample(TShopConfigExample example);

    TShopConfig selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TShopConfig record, @Param("example") TShopConfigExample example);

    int updateByExample(@Param("record") TShopConfig record, @Param("example") TShopConfigExample example);

    int updateByPrimaryKeySelective(TShopConfig record);

    int updateByPrimaryKey(TShopConfig record);
}