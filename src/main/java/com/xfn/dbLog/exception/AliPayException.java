package com.xfn.dbLog.exception;

/**
 * Created by xiaobai on 17/4/5.
 */
public class AliPayException extends XFNException {
    public AliPayException(int code) {
        super(code);
    }

    public AliPayException(String msg) {
        super(msg);
    }

    public AliPayException(int code, String msg) {
        super(code, msg);
    }
}
