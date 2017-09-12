package com.xfn.dbLog.exception;

/**
 * Created by po on 16/8/1.
 */
public class ExcelException extends XFNException {
    public ExcelException(int code) {
        super(code);
    }

    public ExcelException(String msg) {
        super(msg);
    }

    public ExcelException(int code, String msg) {
        super(code, msg);
    }
}
