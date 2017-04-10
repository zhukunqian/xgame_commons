package com.haifi.game.util;

import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * base64 编码解码工具类
 * 
 * @author zhukunqian@gmail.com
 * 
 */
public class Base64Util {
    /**
     * 对str进行base64加密
     * 
     * @param str
     * @return
     */
    public static String encode(String str) {
        try {
            return Base64.encodeBase64String(str.getBytes("UTF-8"));
        } catch (Exception e) {
            log.error("ERROR", e);
        }
        return null;
    }

    /**
     * 对str进行base64解密
     * 
     * @param str
     * @return
     */
    public static String decode(String str) {
        try {
            return new String(Base64.decodeBase64(str), "UTF-8");
        } catch (Exception e) {
            log.error("ERROR", e);
        }
        return null;
    }

    private static final Logger log = LoggerFactory.getLogger(DesUtil.class);
}
