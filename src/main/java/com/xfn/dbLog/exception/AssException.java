package com.xfn.dbLog.exception;

/**
 * Created by po on 16/6/22.
 */
public class AssException extends XFNException{

    public AssException(String msg){
        super(msg);
    }

    public AssException(int code){
        super(code);
    }

    public AssException(int code,String msg){
        super(code,msg);
    }
}
