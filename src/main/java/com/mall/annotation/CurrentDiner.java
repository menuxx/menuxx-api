package com.mall.annotation;

import java.lang.annotation.*;

/**
 * 作者: yinchangsheng@gmail.com
 * 创建于: 2017/2/22
 * 微信: yin80871901
 */
@Target({ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface CurrentDiner {

	String CURRENT_DINER = "CURRENT_DINER";

	String value() default CURRENT_DINER;

}
