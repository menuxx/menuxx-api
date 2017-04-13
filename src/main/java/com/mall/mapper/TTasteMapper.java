package com.mall.mapper;

import com.mall.model.TTaste;
import com.mall.model.TTasteExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TTasteMapper {
    int countByExample(TTasteExample example);

    int deleteByExample(TTasteExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TTaste record);

    int insertSelective(TTaste record);

    List<TTaste> selectByExample(TTasteExample example);

    TTaste selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TTaste record, @Param("example") TTasteExample example);

    int updateByExample(@Param("record") TTaste record, @Param("example") TTasteExample example);

    int updateByPrimaryKeySelective(TTaste record);

    int updateByPrimaryKey(TTaste record);
}