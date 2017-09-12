package com.xfn.dbLog.exception;


/**
 * Created by po on 16/6/17.
 */
public class XFNException extends RuntimeException {

    private int code;

    private String msg;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public XFNException(int code){
        this.code = code;
    }

    public XFNException(String msg) {
        super(msg);
        this.msg = msg;
    }

    public XFNException(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

}
