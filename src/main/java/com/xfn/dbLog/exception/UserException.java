package com.xfn.dbLog.exception;

/**
 * Created by po on 16/5/30.
 */
public class UserException extends XFNException {

    public UserException(String msg) {
        super(msg);
    }

    public UserException(int code, String msg) {
        super(code,msg);
    }

}
