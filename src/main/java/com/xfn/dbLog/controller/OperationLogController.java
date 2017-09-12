package com.xfn.dbLog.controller;

import com.xfn.dbLog.entity.OperationLog;
import com.xfn.dbLog.service.OperationLogService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;

/**
 * @author bike
 * @create 2017-09-12 下午3:42
 **/
@Controller
@RequestMapping(value = "/db/log")
public class OperationLogController {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Resource
    private OperationLogService operationLogService;

    @ResponseBody
    @RequestMapping(value = "/insert")
    public void insertOperation(){
        OperationLog operationLog = new OperationLog();
        operationLog.setServiceIP("111");
        operationLog.setServicePort("99999");
        operationLogService.insert(operationLog);
    }
}
