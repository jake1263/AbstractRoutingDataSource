package com.irish.aop;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import com.irish.config.DynamicDataSourceHolder;
import com.irish.constant.DataSourceType;

import lombok.extern.slf4j.Slf4j;

@Aspect
@Component
@Order(-1)
@Slf4j
public class DataSourcePartAspect {
    /**
     * mapper 查询操作默认使用从库
     */
    @Before("execution(* com..service..*.select*(..)) || execution(* com..service..*.get*(..))|| execution(* com..service..*.query*(..))")
    public void setReadDataSourceType() {
        DynamicDataSourceHolder.putDataSource(DataSourceType.SLAVE);
        log.info("dataSource 切换到：{}",DataSourceType.SLAVE.getName());
    }
 
    /**
     * mapper 修改删除操作默认使用主库库
     */
    @Before("execution(* com..service..*.insert*(..)) || execution(* com..service..*.update*(..)) || execution(* com..service..*.delete*(..))")
    public void setWriteDataSourceType() {
        DynamicDataSourceHolder.putDataSource(DataSourceType.MASTER);
        log.info("dataSource 切换到：{}",DataSourceType.MASTER.getName());
    }
 
}