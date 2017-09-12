package com.xfn.dbLog.utils;

import com.alibaba.fastjson.JSONArray;
import com.xfn.dbLog.exception.ValidateException;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.regex.Pattern;

/**
 * Created by xfn-ac on 16/6/21.
 */
public class Validate {
    public static void checkNotNull(Object obj, String msg) {
        if (null == obj) {
            throw new ValidateException(17000, msg + " 为空");
        }
    }

    public static void checkNotEmpty(String str, String msg) {
        checkNotNull(str, msg);
        if (str.length() == 0) {
            throw new ValidateException(17000, msg + " 为空字符串");
        }
    }

    public static void checkInArray(String str, String[] strlist, String msg) {
        boolean exists = false;
        for (String temp : strlist) {
            if (temp.equals(str)) {
                exists = true;
            }
        }
        if (!exists) {
            throw new ValidateException(17000, msg + " 不存在于 " + JSONArray.toJSONString(strlist));
        }

    }

    public static void checkNotEmpty(JSONArray arr, String msg) {
        checkNotNull(arr, msg);
        if (arr.size() == 0) {
            throw new ValidateException(17000, msg + " 为空数组");
        }
    }

    public static void checkListIsNumber(JSONArray arr, String msg) {
        for (Object obj : arr) {
            if (obj instanceof String) {
                checkNumericString(String.valueOf(obj), msg);
            }
        }
    }

    public static void checkNumericString(String str, String msg) {
        checkNotNull(str, msg);
        checkNotEmpty(str, msg);
        Pattern pattern = Pattern.compile("^-?\\d+(?:\\.\\d*)?$");
        if (!pattern.matcher(str).matches()) {
            throw new ValidateException(17000, msg + "[" + str + "]未能正确识别为数字字符串");
        }
    }

    /**
     * 只能是正数
     *
     * @param str
     * @param msg
     */
    public static void checkStringIsPositive(String str, String msg) {
        checkNotNull(str, msg);
        Pattern pattern = Pattern.compile("^\\d+(?:\\.\\d*)?$");
        if (!pattern.matcher(str).matches()) {
            throw new ValidateException(17000, msg + " 未能正确识别为正数数字字符串");
        }
    }

    public static void checkStringIsPositiveInteger(String str, String msg) {
        checkNotNull(str, msg);
        Pattern pattern = Pattern.compile("^\\d+(?:\\.00)?$");
        if (!pattern.matcher(str).matches()) {
            throw new ValidateException(17000, msg + " 未能正确识别为正整数");
        }
    }

    public static void checkNumericIsInt(String str, String msg) {
        checkNotNull(str, msg);
        Pattern pattern = Pattern.compile("^[1-9][\\d]*$");
        if (!pattern.matcher(str).matches()) {
            throw new ValidateException(17000, msg + " 不是正整数");
        }
    }

    public static void checkNumericArray(JSONArray arr, String msg) {
        checkNotNull(arr, msg);
        for (int i = 0; i < arr.size(); i++) {
            String str = arr.get(i).toString();
            Pattern pattern = Pattern.compile("^-?\\d+(?:\\.\\d*)?$");
            if (!pattern.matcher(str).matches()) {
                throw new ValidateException(17000, msg + " 存在不为数字类型的值 " + str);
            }
        }
    }

    public static void checkStringArray(JSONArray arr, String msg) {
        checkNotNull(arr, msg);
        for (int i = 0; i < arr.size(); i++) {
            if (!(arr.get(i) instanceof String)) {
                throw new ValidateException(17000, msg + " 存在不为字符串类型的值 " + arr.get(i).toString());
            }
        }
    }

    public static void checkDateString(String str, String msg) {
        checkNotNull(str, msg);
        Pattern pattern = Pattern.compile("^\\d{4}-\\d{2}-\\d{2}$");
        if (!pattern.matcher(str).matches()) {
            throw new ValidateException(17000, msg + " 日期格式不正确 " + str);
        }
        // 指定日期格式为四位年/两位月份/两位日期，注意yyyy/MM/dd区分大小写；
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        try {
            //设置lenient为false. 否则SimpleDateFormat会比较宽松地验证日期，比如2007/02/29会被接受，并转换成2007/03/01
            format.setLenient(false);
            format.parse(str);
        } catch (ParseException e) {
            throw new ValidateException(17000, msg + " 日期时间不正常 " + str);
        }
    }

    public static void checkStringLength(String str, int min, int max, String msg) {
        checkNotNull(str, msg);
        if (str.length() < min || str.length() > max) {
            throw new ValidateException(17000, msg + " 长度不符合要求 " + min + "-" + max);
        }
    }

    public static void checkNumberRange(String month, int min, int max, String str) {
        BigDecimal monthBig = new BigDecimal(month);
        if (monthBig.intValue() < min || monthBig.intValue() > max) {
            throw new ValidateException(17000, "" + str + " 大小应在" + min + "-" + max + "之间");
        }
    }

    public static void checkParity(int len, String parity, String msg) {
        if (parity.equals("even")) {
            if (len % 2 != 0) {
                throw new ValidateException(17000, msg + " 长度不符合偶数要求");
            }
        } else if (parity.equals("odd")) {
            if (len % 2 == 0) {
                throw new ValidateException(17000, msg + " 长度不符合奇数要求");
            }
        } else {
            throw new ValidateException(17000, " 请输入正确的校验类型(奇偶性)");
        }
    }

    public static void checkContains(String source, String target, String msg) {
        checkNotNull(source, msg);
        checkNotNull(target, msg);
        if (!source.contains(target)) {
            throw new ValidateException(17000, msg + source + " 未包含 " + target);
        }
    }

    //检查一个数字字符串的长度以及奇偶性
    public static void checkNumericStringLengthAndParity(String str, int min, int max, String parity, String msg) {
        checkNumericString(str, msg);
        checkStringLength(str, min, max, msg);
        checkParity(str.length(), parity, msg);
        str.trim();
    }

    //校验年份是否在指定的空间
    public static void checkYear(String year) {
        int y = Integer.parseInt(year);
        if (y < 2000 || y > 2030) {
            throw new ValidateException(17000, "  年份不符合要求: " + 2000 + "-" + 2030);
        }
    }

    //校验月份是否存在
    public static void checkMonth(String month) {
        int m = Integer.parseInt(month);
        if (m < 1 || m > 12) {
            throw new ValidateException(17000, "  月份不符合要求: " + 1 + "-" + 12);
        }
    }

    //校验时间日期是否在指定范围
    public static void checkDate(String date) {
        try {
            Calendar before = Calendar.getInstance();
            Calendar after = Calendar.getInstance();
            Calendar now = Calendar.getInstance();
            SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
            before.set(2000, 1, 1);
            after.set(2030, 1, 1);
            now.setTime(format.parse(date));
            if (now.after(after) || now.before(before)) {
                throw new ValidateException(17000, " 日期时间不在指定范围之内 2000-2030");
            }
        } catch (ParseException e) {
            throw new ValidateException(17000, " 日期时间不正常 " + date);
        }


    }

    /**
     * 2017-05-18 xiaobai
     * 校验字符串时1-5数字开头
     *
     * @param serialNumber
     * @param str
     */
    public static void checkStr1T5Begin(String serialNumber, String str) {
        if (!serialNumber.matches("[1-5]+.*")) {
            throw new ValidateException(17000, str + "只允许1-5数字开头");
        }
    }

    public static void checkStr1T5Begin(String serialNumber, int length, String str) {
        if (serialNumber.length() != length) {
            throw new ValidateException(17000, str + " 长度不符合要求，只允许3位数");
        }

        if (!serialNumber.matches("[1-5]+.*")) {
            throw new ValidateException(17000, str + "只允许1-5数字开头");
        }

    }

    /**
     * 2017-05-18 xiaobai
     * 校验字符串时1-5数字开头数组
     *
     * @param cfNumArray
     * @param str
     */
    public static void checkStr1T5BeginArr(JSONArray cfNumArray, int length, String str) {
        String cf;
        for (int i = 0; i < cfNumArray.size(); i++) {
            cf = cfNumArray.getString(i);
            checkStr1T5Begin(cf, length, "编码");
        }

    }
}
