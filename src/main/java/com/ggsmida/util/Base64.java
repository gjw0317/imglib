package com.ggsmida.util;


import org.apache.commons.lang.StringUtils;
import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**
 * Created by junwuguo on 2017/1/11 0011.
 */
public class Base64 {

    public static String encode(String s) {
        if (StringUtils.isNotBlank(s)) {
            BASE64Encoder encoder = new BASE64Encoder();
            try {
                return encoder.encode(s.getBytes());
            } catch (Exception e) {
                return "";
            }
        } else {
            return "";
        }
    }

    public static String decode(String s) {
        if (StringUtils.isNotBlank(s)) {
            BASE64Decoder decoder = new BASE64Decoder();
            try {
                byte[] result = decoder.decodeBuffer(s);
                return new String(result);
            } catch (Exception e) {
                return "";
            }
        } else {
            return "";
        }
    }

    public static void main(String args[]) {
        String base64String = "MTIzNDU2";
        String normalString = "123456";
        System.out.println(normalString + "==>" + Base64.encode(normalString));
        System.out.println(base64String + "==>" + Base64.decode(base64String));
    }
}
