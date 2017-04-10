package com.haifi.game.util;

import org.junit.Test;

public class RandomUtilTest {
    @Test
    public void testIndex() {
        int[] rates = new int[] { 5, 1, 5, 1 };
        for (int m = 0; m < 100; m++) {
            System.out.println(RandomUtil.randomIndex(rates));
        }
    }
}
