package com.xfn.dbLog.exception;

/**
 * Created by po on 16/6/30.
 */
public class JvException extends XFNException {
    public JvException(int code) {
        super(code);
    }

    public JvException(String msg) {
        super(msg);
    }

    public JvException(int code, String msg) {
        super(code, msg);
    }

}
