package com.young.java.example.hbase;

import org.apache.hadoop.hbase.client.Table;

/**
 * Created by dell on 2016/4/22.
 */
public interface HTableCallBack<T> {
    T callback(Table table) throws Exception;
}
