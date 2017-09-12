package com.xfn.dbLog.enums;

/**
 * Created by xfn-bike on 17/5/9.
 */
public enum Authorization {
    AUTH_ADMIN(0,"管理员"),
    AUTH_OP(1,"记账员"),
    AUTH_OBER(2,"观察员")
    ;
    private int code;

    private String auth;

    public int getCode() {
        return code;
    }

    public String getAuth() {
        return auth;
    }

    Authorization(int code, String auth){
        this.code = code;
        this.auth = auth;
    }

    public static Authorization codeOf(int code){
        for (Authorization authorization : values()){
            if (authorization.getCode() == code){
                return authorization;
            }
        }
        return null;
    }
}
