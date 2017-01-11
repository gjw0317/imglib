package com.ggsmida.base;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by junwuguo on 2017/1/11 0011.
 */
public class Constant {

    private Constant() {

    }

    public static SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    public static SimpleDateFormat dateTimeFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    public static String defaultBirthDateStr = "1990-01-01";

    public static Date getDefaultBirthDate() throws ParseException {
        return dateFormat.parse(defaultBirthDateStr);
    }


}
