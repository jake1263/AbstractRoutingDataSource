package com.irish.config;

import com.irish.constant.DataSourceType;

public class DynamicDataSourceHolder {
 
    private static final ThreadLocal<String> holder = new ThreadLocal<String>();
 
    public static void putDataSource(DataSourceType dataSourceType) {
        holder.set(dataSourceType.getType());
    }
 
    public static String getDataSouce() {
        return holder.get();
    }
}