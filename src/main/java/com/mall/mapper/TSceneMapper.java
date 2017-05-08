package com.mall.mapper;

import com.mall.model.TScene;
import com.mall.model.TSceneExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface TSceneMapper {
    int countByExample(TSceneExample example);

    int deleteByExample(TSceneExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(TScene record);

    int insertSelective(TScene record);

    List<TScene> selectByExample(TSceneExample example);

    TScene selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") TScene record, @Param("example") TSceneExample example);

    int updateByExample(@Param("record") TScene record, @Param("example") TSceneExample example);

    int updateByPrimaryKeySelective(TScene record);

    int updateByPrimaryKey(TScene record);
}