package com.xfn.dbLog.dto;

import com.xfn.dbLog.enums.ReturnEnum;
import org.springframework.util.StringUtils;

/**
 * Created by po on 16/5/30.
 */
public class ReturnResult<T> {

    private T data;

    private int code;

    private String message;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ReturnResult(ReturnEnum returnEnum) {
        this.code = returnEnum.getCode();
        this.message = returnEnum.getMessage();
    }

    public ReturnResult(ReturnEnum returnEnum, T data) {
        this.data = data;
        this.code = returnEnum.getCode();
        this.message = returnEnum.getMessage();
    }

    public ReturnResult(T data) {
        this.data = data;
    }

    //参数顺序需要与上一个构造方法相反,用以区分
    public ReturnResult(String addmsg,ReturnEnum returnEnum){
        if (!StringUtils.hasText(addmsg)){
            addmsg = "";
        }
        this.code = returnEnum.getCode();
        this.message = returnEnum.getMessage() + addmsg;
    }


    public ReturnResult(T data, ReturnEnum returnEnum, String addmsg) {
        this.data = data;
        this.code = returnEnum.getCode();
        this.message = returnEnum.getMessage() + addmsg;
    }
}

