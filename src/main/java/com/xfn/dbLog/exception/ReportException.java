package com.xfn.dbLog.exception;

/**
 * Created by xfn-ac on 16/6/20.
 */
public class ReportException extends XFNException {

    public ReportException(String msg) {
        super(msg);
    }

    public ReportException(int code) {
        super(code);
    }

    public ReportException(int code, String msg) {
        super(code, msg);
    }
}
