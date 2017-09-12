package com.xfn.dbLog.exception;


/**
 * Created by xfn-ac on 16/6/20.
 */
public class AcException extends XFNException {

    public AcException(String msg){
        super(msg);
    }

    public AcException(int code){
        super(code);
    }

    public AcException(int code,String msg){
        super(code,msg);
    }

}
