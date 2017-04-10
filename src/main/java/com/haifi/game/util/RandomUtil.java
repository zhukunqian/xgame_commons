package com.haifi.game.util;

import java.util.List;

import org.apache.commons.lang3.RandomUtils;

public class RandomUtil {
    public static int randomIndex(List<Integer> rates) {
        int totalRates = 0;
        for (int rate : rates) {
            totalRates += rate;
        }
        if (totalRates == 0) {
            return -1;
        }
        int randomRate = RandomUtils.nextInt(0, totalRates);

        for (int m = 0; m < rates.size(); m++) {
            if (randomRate < rates.get(m)) {
                return m;
            } else {
                randomRate -= rates.get(m);
            }
        }
        return -1;
    }

    public static int randomIndex(int[] rates) {
        int totalRates = 0;
        for (int rate : rates) {
            totalRates += rate;
        }
        if (totalRates == 0) {
            return -1;
        }
        int randomRate = RandomUtils.nextInt(0, totalRates);
        for (int m = 0; m < rates.length; m++) {
            if (randomRate < rates[m]) {
                return m;
            } else {
                randomRate -= rates[m];
            }
        }
        return -1;
    }

}
