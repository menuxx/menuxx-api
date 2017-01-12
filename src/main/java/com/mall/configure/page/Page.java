package com.mall.configure.page;

import java.lang.annotation.ElementType;
import java.lang.annotation.Target;

/**
 * Created by Supeng on 7/21/16.
 */
@Target(ElementType.METHOD)
public @interface Page {

    String value() default "PAGE";

}
