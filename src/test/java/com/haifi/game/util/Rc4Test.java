package com.haifi.game.util;

import org.junit.Test;

public class Rc4Test {
    @Test
    public void test1() {
        String a = "hello world";
        String key = "abc";
        System.out.println(new String(Rc4Util.encode(a, key)));
        System.out.println(new String(Rc4Util.decode(Rc4Util.encode(a, key), key)));

    }
}
