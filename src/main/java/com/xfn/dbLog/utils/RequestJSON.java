package com.xfn.dbLog.utils;

import com.alibaba.fastjson.JSONObject;
import com.xfn.dbLog.exception.XFNException;

import javax.servlet.http.HttpServletRequest;
import java.io.BufferedReader;

/**
 * Created by xfn-ac on 16/6/13.
 */
public class RequestJSON {

    //获得前台传来的数据转换成json
    public static JSONObject parse(HttpServletRequest request) {

        StringBuilder sb = new StringBuilder();

        try {
            BufferedReader reader = request.getReader();
            char[] buff = new char[1024];
            int len;
            while ((len = reader.read(buff)) != -1) {
                sb.append(buff, 0, len);
            }
        } catch (Exception e) {
            e.printStackTrace();
            throw new XFNException(17000);
        }

        System.out.println("前台传入json数据：" + sb.toString());
        return JSONObject.parseObject(sb.toString());


    }
}
