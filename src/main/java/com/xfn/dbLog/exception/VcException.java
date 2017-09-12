package com.xfn.dbLog.exception;

/**
 * Created by xfn-ac on 16/6/20.
 */
public class VcException extends XFNException {

    public VcException(String msg){
        super(msg);
    }

    public VcException(int code){
        super(code);
    }

    public VcException(int code,String msg){
        super(code,msg);
    }

}
