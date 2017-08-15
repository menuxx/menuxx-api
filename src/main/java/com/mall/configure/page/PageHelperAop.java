package com.mall.configure.page;

import com.github.pagehelper.PageHelper;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;

/**
 * Created by Supeng on 7/21/16.
 */
@Aspect
@Configuration
public class PageHelperAop {

    static final Logger logger = LoggerFactory.getLogger(PageHelperAop.class);

    @Before(value = "@annotation(com.mall.configure.page.Page)")
    public void setPageHelper(JoinPoint joinPoint) throws Exception {
        // 获取请求参数
        Object[] args = joinPoint.getArgs();
        if (args.length >= 2) {
            int pageNum = (Integer) args[args.length - 2];
            int pageSize = (Integer) args[args.length - 1];
            logger.debug("pageNum=" + pageNum + ", pageSize=" + pageSize);
            PageHelper.offsetPage((pageNum - 1) * pageSize, pageSize);
        }

    }
}
