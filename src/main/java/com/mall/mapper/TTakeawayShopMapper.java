package com.mall.mapper;

import com.mall.model.TTakeawayShop;
import com.mall.model.TTakeawayShopExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTakeawayShopMapper {
    int countByExample(TTakeawayShopExample example);

    int deleteByExample(TTakeawayShopExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTakeawayShop record);

    int insertSelective(TTakeawayShop record);

    List<TTakeawayShop> selectByExample(TTakeawayShopExample example);

    TTakeawayShop selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTakeawayShop record, @Param("example") TTakeawayShopExample example);

    int updateByExample(@Param("record") TTakeawayShop record, @Param("example") TTakeawayShopExample example);

    int updateByPrimaryKeySelective(TTakeawayShop record);

    int updateByPrimaryKey(TTakeawayShop record);
}