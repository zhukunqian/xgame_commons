package com.haifi.game.util;

import org.apache.commons.codec.digest.DigestUtils;

/**
 * 获取md5字符串
 * 
 * @author zhukunqian@gmail.com
 * 
 */
public class Md5Util {
    public static final String md5(String info) {
        return DigestUtils.md5Hex(info);
    }
}
