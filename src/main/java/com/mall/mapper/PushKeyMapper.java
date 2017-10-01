package com.mall.mapper;

import com.mall.model.TPushKey;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/9/30
 * 微信: yin80871901
 */
public interface PushKeyMapper {

	List<TPushKey> selectAvailableKeysByUserId(@Param("userId") Integer userId, @Param("now") Date now);

}
