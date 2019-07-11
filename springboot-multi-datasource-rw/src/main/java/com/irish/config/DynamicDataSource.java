package com.irish.config;
import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

import com.irish.constant.DataSourceType;
 
public class DynamicDataSource extends AbstractRoutingDataSource {
 
    @Override
    protected Object determineCurrentLookupKey() {
        if (DynamicDataSourceHolder.getDataSouce() != null) {
            return DynamicDataSourceHolder.getDataSouce();
        }
        return DataSourceType.MASTER.getType();
    }
}