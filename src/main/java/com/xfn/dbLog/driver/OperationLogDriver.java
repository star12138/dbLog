package com.xfn.dbLog.driver;

import com.xfn.dbLog.dao.OperationLogDao;
import com.xfn.dbLog.entity.OperationLog;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;

/**
 * @author
 * @create 2017-09-12 下午3:53
 **/
@Component("operationLogDriver")
public class OperationLogDriver {

    @Resource
    private OperationLogDao operationLogDao;

    public void insert(OperationLog operationLog) {
        operationLogDao.insert(operationLog);
    }
}
