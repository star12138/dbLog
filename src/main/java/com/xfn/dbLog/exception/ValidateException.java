package com.xfn.dbLog.exception;

/**
 * Created by xfn-ac on 16/6/21.
 */
public class ValidateException extends XFNException {

    public ValidateException(String msg){
        super(msg);
    }

    public ValidateException(int code){
        super(code);
    }

    public ValidateException(int code,String msg){
        super(code,msg);
    }
}
