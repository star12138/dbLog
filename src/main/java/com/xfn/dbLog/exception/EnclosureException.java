package com.xfn.dbLog.exception;


/**
 * Created by xfn-ac on 16/6/20.
 */
public class EnclosureException extends XFNException {

    public EnclosureException(String msg){
        super(msg);
    }

    public EnclosureException(int code){
        super(code);
    }

    public EnclosureException(int code, String msg){
        super(code,msg);
    }

}
