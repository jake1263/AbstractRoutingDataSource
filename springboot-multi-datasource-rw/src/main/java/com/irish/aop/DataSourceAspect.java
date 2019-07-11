package com.irish.aop;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.irish.anno.DataSource;
import com.irish.config.DynamicDataSourceHolder;
import com.irish.constant.DataSourceType;

import lombok.extern.slf4j.Slf4j;
 

/**
 * order 的值越小，说明越先被执行
 *
 */
@Aspect
@Component
@Order(0)
@Slf4j
public class DataSourceAspect{
 
    /**
     * 注解方式
     * @param joinPoint
     * @param dataSource
     */
    @Before(value = "@annotation(dataSource)")
    public void dataSourcePoint(JoinPoint joinPoint, DataSource dataSource) {
        DynamicDataSourceHolder.putDataSource(dataSource.value());
        log.info("通过注解 dataSource 切换到：{}",dataSource.value());
    }
 
    
}