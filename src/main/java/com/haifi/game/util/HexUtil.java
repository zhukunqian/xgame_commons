package com.haifi.game.util;

import java.nio.charset.StandardCharsets;

import org.apache.commons.codec.DecoderException;
import org.apache.commons.codec.binary.Hex;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class HexUtil {
    public static String encode(String data) {
        return encode(data.getBytes(StandardCharsets.UTF_8));
    }

    public static String encode(byte[] data) {
        return Hex.encodeHexString(data);
    }

    public static byte[] decode(String hex) {
        try {
            return Hex.decodeHex(hex.toCharArray());
        } catch (DecoderException e) {
            log.error("ERROR", e);
        }
        return null;
    }

    private static final Logger log = LoggerFactory.getLogger(Rc4Util.class);
}
