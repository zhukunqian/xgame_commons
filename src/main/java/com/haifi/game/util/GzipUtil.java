package com.haifi.game.util;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;

import org.apache.commons.io.IOUtils;

/**
 * gzip 压缩解压
 * 
 * @author zhukunqian@gmail.com
 *
 */
public class GzipUtil {
    public static byte[] gzip(byte[] data) {
        try {
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(arrayOutputStream);
            gzipOutputStream.write(data);
            gzipOutputStream.finish();
            gzipOutputStream.flush();
            gzipOutputStream.close();
            byte[] gzipData = arrayOutputStream.toByteArray();
            return gzipData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public static byte[] gzip(byte[] data, int offset, int len) {
        try {
            ByteArrayOutputStream arrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gzipOutputStream = new GZIPOutputStream(arrayOutputStream);
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

    public static byte[] ungzip(byte[] data) {
        try {
            ByteArrayInputStream arrayInputStream = new ByteArrayInputStream(data);
            GZIPInputStream gzipInputStream = new GZIPInputStream(arrayInputStream);
            byte[] ungzipData = IOUtils.toByteArray(gzipInputStream);
            return ungzipData;
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
