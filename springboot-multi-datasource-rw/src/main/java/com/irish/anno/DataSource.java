package com.irish.anno;
import java.lang.annotation.*;

import com.irish.constant.DataSourceType;
 
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Documented
@Inherited
public @interface DataSource {
 
    /**
     * 数据库路由
     */
    DataSourceType value() default DataSourceType.MASTER;
}