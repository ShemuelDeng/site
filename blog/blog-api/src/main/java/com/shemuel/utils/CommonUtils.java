package com.shemuel.utils;

import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.UUID;

public class CommonUtils {
    public static String  dateFommat(Date date) {
        try {
            SimpleDateFormat sdf = new SimpleDateFormat("YYYY-MM-dd HH:mm:ss");
            return sdf.format(date);
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
    public static String getUuid () {
        return UUID.randomUUID().toString().replace("-", "").toLowerCase();
    }

    public static String upperFirstWord(String words){
        return words.substring(0,1).toUpperCase() + words.substring(1);
    }

    public static Boolean isEmptyString(String s) {
        return (s == null || s.length() == 0);
    }
    public static Boolean isNotEmptyString(String s){
        return !isEmptyString(s);
    }
}
