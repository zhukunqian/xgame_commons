package com.haifi.game.util;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class StringUtil {
    public static String parse(String content, String regEx) {
        Pattern p = Pattern.compile(regEx, Pattern.DOTALL);
        Matcher m = p.matcher(content);
        if (m.find()) {
            return m.group(1);
        } else {
            return null;
        }
    }

    public static List<String> parseString(String content, String regEx) {
        List<String> returnStrs = new ArrayList<String>();
        Pattern p = Pattern.compile(regEx, Pattern.DOTALL);
        Matcher m = p.matcher(content);
        while (m.find()) {
            for (int i = 1; i <= m.groupCount(); i++) {
                returnStrs.add(m.group(i));
            }
        }
        return returnStrs;
    }

    private static final Logger log = LoggerFactory.getLogger(Rc4Util.class);
}
