package com.shemuel.utils;

import java.text.SimpleDateFormat;
import java.util.Date;
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
}
