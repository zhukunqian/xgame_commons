package com.haifi.game.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.ZipInputStream;
import java.util.zip.ZipOutputStream;

import org.apache.commons.io.IOUtils;

/**
 * zip 压缩解压
 * 
 * @author zhukunqian@gmail.com
 * 
 */
public class ZipUtil {

    public static byte[] zip(byte[] data) {
        return zip(data, 0, data.length);
    }

    public static byte[] zip(byte[] data, int offset, int len) {
        try {
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            ZipOutputStream gzipOutputStream = new ZipOutputStream(arrayOutputStream);
            gzipOutputStream.write(data, offset, len);
            gzipOutputStream.finish();
            gzipOutputStream.flush();
            gzipOutputStream.close();
            byte[] gzipData = arrayOutputStream.toByteArray();
            return gzipData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] unzip(byte[] data) {
        try {
            ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(data);
            ZipInputStream gzipInputStream = new ZipInputStream(arrayInputStream);
            byte[] ungzipData = IOUtils.toByteArray(gzipInputStream);
            return ungzipData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
