package com.xfn.dbLog.utils;/**
 * Created by xfn-hy on 16/10/17.
 */

import org.apache.commons.codec.binary.Hex;

import javax.servlet.http.HttpServletRequest;
import java.io.UnsupportedEncodingException;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.UUID;
import java.util.regex.Pattern;

/**
 * 用于存放常用的方法
 *
 * @author
 * @create 2016-10-17 下午3:06
 **/
public class MyUtils<V> {

    private static MyUtils myUtils = new MyUtils();

    private MyUtils() {

    }

    //获取myutils对象
    public static MyUtils getMyUtils() {
        return myUtils;
    }

    /**
     * 将月份转换成需要的格式,9以下的月份前面添0
     *
     * @param mon
     * @return
     */
    public static String getMonthString(int mon) {
        if (mon <= 9) {
            return "" + 0 + mon;
        } else {
            return "" + mon;
        }
    }

    /**
     * 获取所传入日期的上一个月
     *
     * @param time '201612' 这种样式
     * @return
     */
    public static String getYearMonth(String time) {
        String year = time.substring(0, 4);
        String month = time.substring(4);
        if (month.equals("01")) {
            month = "12";
            year = Integer.parseInt(year) - 1 + "";
        } else {
            month = getMonthString(Integer.parseInt(month) - 1);
        }
        return year + month;
    }

    /**
     * 获取uuid
     *
     * @return
     */
    public static String getUUID() {
        UUID uuid = UUID.randomUUID();
        String str = uuid.toString();
        return str.replace("-", "");
    }

    /**
     * 专门处理corpId带其它异常字符串
     *
     * @param referCorpId
     * @return
     */
    public static String getCorpId(String referCorpId) {

        String corpId = "";
        char[] arr = referCorpId.toCharArray();
        String regEx = "[A-Za-z0-9]+";
        Pattern pattern = Pattern.compile(regEx);
        for (char c : arr) {
            if (pattern.matcher(c + "").matches()) {
                corpId = corpId + c;
            } else {
                break;
            }
        }
//        if (referCorpId.indexOf("?") > 0) {
//            referCorpId = referCorpId.substring(0, referCorpId.indexOf("?"));
//        }
//
//        if (referCorpId.indexOf("&") > 0) {
//            referCorpId = referCorpId.substring(0, referCorpId.indexOf("&"));
//        }
        return corpId;
    }

    public static String getToken(HttpServletRequest request) throws NoSuchAlgorithmException, UnsupportedEncodingException {

        String result = "";
        Enumeration enumeration = request.getParameterNames();
        while (enumeration.hasMoreElements()) {
            result += request.getParameter((String) enumeration.nextElement());
        }
        return getMD5(result);
    }

    public static String getMD5(String str) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        MessageDigest md5 = MessageDigest.getInstance("MD5");
        byte[] by = md5.digest(str.getBytes("utf-8"));
        return Hex.encodeHexString(by);
    }

    /**
     * 2017-04-05 bike
     * 获取list中的拼接值,通过regex
     *
     * @param strList
     * @param regex
     * @return
     */
    public static String getListString(List<String> strList, String regex) {
        String result = "";
        for (String str : strList) {
            result = result + str + regex;
        }
        return result.substring(0, result.length() - 1);
    }

    /**
     * 获取list集合中某一属性值的集合
     *
     * @param objects
     * @param propertyName
     * @return
     */
    public List<String> getElements(List<V> objects, String propertyName) {
        List<String> propertyElements = new ArrayList<>();

        for (V v : objects) {
            Class<?> clazz = v.getClass();
            //校验字段是否存在
            Field field;
            try {
                field = clazz.getDeclaredField(propertyName);
            } catch (NoSuchFieldException e) {
                return this.getEmptyValues();
            }
            if (field == null) {
                return this.getEmptyValues();
            }

            StringBuilder nameBuffer = new StringBuilder();
            nameBuffer.append(ElementsMethod.GET.getMethodHeadCode()).append(propertyName);

            Method propertyNameMethod = null;
            Method[] methods = clazz.getMethods();
            if (methods == null || methods.length == 0) {
                return this.getEmptyValues();
            }
            for (Method method : methods) {
                if (method.getName().toUpperCase().equals(nameBuffer.toString().toUpperCase())) {
                    propertyNameMethod = method;
                    break;
                }
            }

            //找不到该字段的get方法
            if (propertyNameMethod == null) {
                return this.getEmptyValues();
            }

            try {
                propertyElements.add((String) propertyNameMethod.invoke(v));
            } catch (InvocationTargetException e) {
                return this.getEmptyValues();
            } catch (IllegalAccessException e) {
                return this.getEmptyValues();
            }

        }

        return propertyElements;
    }

    /**
     * 返回一个空的list集合
     *
     * @return
     */
    private List<String> getEmptyValues() {
        return new ArrayList<>(0);
    }

    protected enum ElementsMethod {

        /**
         * get方法
         */
        GET("get"),

        /**
         * boolean方法
         */
        IS("is"),

        /**
         * set方法
         */
        SET("set");

        /**
         * 方法头参数
         */
        private String methodHeadCode;

        /**
         * 构造方法
         *
         * @param methodHeadCode
         */
        private ElementsMethod(String methodHeadCode) {
            this.methodHeadCode = methodHeadCode;
        }

        /**
         * 获取方法Head枚举
         *
         * @return
         */
        private String getMethodHeadCode() {
            return methodHeadCode;
        }

    }

}

