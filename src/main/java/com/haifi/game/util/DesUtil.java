package com.haifi.game.util;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * des 加密解密
 * 
 * @author zhukunqian@gmail.com
 *
 */
public class DesUtil {
    private static final Charset DEFAULT_CHARSET = StandardCharsets.UTF_8;

    public static String encrypt(String key, String str) {
        return new String(encrypt(key, str.getBytes(DEFAULT_CHARSET)), DEFAULT_CHARSET);
    }

    public static String decrypt(String key, String str) {
        return new String(decrypt(key, str.getBytes(DEFAULT_CHARSET)), DEFAULT_CHARSET);
    }

    public static byte[] encrypt(String key, byte[] str) {
        try {
            DESKeySpec dks = new DESKeySpec(key.getBytes());
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
            SecretKey desKey = skf.generateSecret(dks);

            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE, desKey);
            return cipher.doFinal(str);
        } catch (Exception e) {
            log.error("ERROR", e);
        }
        return null;
    }

    public static byte[] decrypt(String key, byte[] str) {
        try {
            DESKeySpec dks = new DESKeySpec(key.getBytes());
            SecretKeyFactory skf = SecretKeyFactory.getInstance("DES");
            SecretKey desKey = skf.generateSecret(dks);
            Cipher cipher = Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE, desKey);
            return cipher.doFinal(str);
        } catch (Exception e) {
            log.error("ERROR", e);
        }
        return null;
    }

    private static final Logger log = LoggerFactory.getLogger(DesUtil.class);
}
