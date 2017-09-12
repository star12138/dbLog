package com.xfn.dbLog.exception;

/**
 * Created by po on 16/6/14.
 */
public class SobException extends XFNException {

    public SobException(String msg){
        super(msg);
    }

     public SobException(int code){
         super(code);
     }

    public SobException(int code,String msg){
        super(code,msg);
    }

}
