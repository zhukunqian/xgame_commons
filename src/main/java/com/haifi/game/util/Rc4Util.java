package com.haifi.game.util;

import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * rc4 加解密
 * 
 * @author zhukunqian@gmail.com
 * 
 */
public class Rc4Util {
    private static String algorithm = "RC4";

    public static byte[] encode(String data, byte[] key) {
        return encode(data.getBytes(StandardCharsets.UTF_8), key);
    }

    public static byte[] encode(String data, String key) {
        return encode(data.getBytes(StandardCharsets.UTF_8), key);
    }

    public static byte[] encode(byte[] data, String key) {
        return encode(data, key.getBytes(StandardCharsets.UTF_8));
    }

    public static byte[] encode(byte[] data, byte[] key) {
        try {
            SecureRandom sr = new SecureRandom(key);
            KeyGenerator kg = KeyGenerator.getInstance(algorithm);
            kg.init(sr);
            SecretKey sk = kg.generateKey();
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.ENCRYPT_MODE, sk);
            byte[] encrypted = cipher.doFinal(data);
            return encrypted;
        } catch (Exception e) {
            log.error("ERROR", e);
        }
        return null;
    }

    public static byte[] decode(byte[] data, String key) {
        try {
            SecureRandom sr = new SecureRandom(key.getBytes());
            KeyGenerator kg = KeyGenerator.getInstance(algorithm);
            kg.init(sr);
            SecretKey sk = kg.generateKey();
            Cipher cipher = Cipher.getInstance(algorithm);
            cipher.init(Cipher.DECRYPT_MODE, sk);
            byte[] decrypted = cipher.doFinal(data);
            return decrypted;
        } catch (Exception e) {
            log.error("ERROR", e);
        }
        return null;
    }

    private static final Logger log = LoggerFactory.getLogger(Rc4Util.class);
}
