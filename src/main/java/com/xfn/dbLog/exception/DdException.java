package com.xfn.dbLog.exception;

/**
 * Created by po on 7/9/16.
 */

public class DdException extends XFNException {

	public DdException(String msg){
		super(msg);
	}

	public DdException(int code){
		super(code);
	}

	public DdException(int code,String msg){
		super(code,msg);
	}

}