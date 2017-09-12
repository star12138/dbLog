package com.xfn.dbLog.exception;

/**
 * Created by po on 16/6/17.
 */
public class RedisException extends XFNException {

    public RedisException(String msg){
        super(msg);
    }

    public RedisException(int code){
        super(code);
    }

    public RedisException(int code,String msg){
        super(code,msg);
    }

}
