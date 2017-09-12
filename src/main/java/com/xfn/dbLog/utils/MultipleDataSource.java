package com.xfn.dbLog.utils;

import org.springframework.jdbc.datasource.lookup.AbstractRoutingDataSource;

/**
 * Created by po on 16/6/3.
 */
public class MultipleDataSource extends AbstractRoutingDataSource{

    private static final ThreadLocal<String> dataSourceKey = new InheritableThreadLocal<String>();

    public static void setDataSourceKey(String dataSource){
        dataSourceKey.set(dataSource);
    }

    protected Object determineCurrentLookupKey() {
        return dataSourceKey.get();
    }
}
