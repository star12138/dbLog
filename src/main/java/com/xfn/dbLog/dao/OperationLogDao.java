package com.xfn.dbLog.dao;


import com.xfn.dbLog.entity.OperationLog;
import org.apache.ibatis.annotations.Param;


public interface OperationLogDao {

    int insertOperationLog(OperationLog log);

    void insert(@Param("operationLog") OperationLog operationLog);

}
