package com.xfn.dbLog.exception;

/**
 * Created by xfn-ac on 16/6/20.
 */
public class BaException extends XFNException {

    public BaException(String msg){
        super(msg);
    }

    public BaException(int code){
        super(code);
    }

    public BaException(int code,String msg){
        super(code,msg);
    }
}
