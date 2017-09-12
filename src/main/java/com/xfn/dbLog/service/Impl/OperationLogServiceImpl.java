package com.xfn.dbLog.service.Impl;

import com.xfn.dbLog.driver.OperationLogDriver;
import com.xfn.dbLog.entity.OperationLog;
import com.xfn.dbLog.service.OperationLogService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * @author
 * @create 2017-09-12 下午3:52
 **/
@Service("operationLogService")
public class OperationLogServiceImpl implements OperationLogService {

    @Resource
    private OperationLogDriver operationLogDriver;

    @Override
    public void insert(OperationLog operationLog) {
        operationLogDriver.insert(operationLog);
    }
}
