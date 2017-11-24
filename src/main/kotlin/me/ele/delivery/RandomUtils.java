package me.ele.delivery;

import java.util.Random;

/**
 * 随机数生成器工具类
 */
public class RandomUtils {
    private static RandomUtils instance = new RandomUtils();

    private RandomUtils() {
    }

    public static RandomUtils getInstance() {
        return instance;
    }

    private Random random = new Random();

    /**
     * 随机生成min和max之间一个数，包括min不包括max
     *
     * @param min
     * @param max
     * @return [min, max)
     */
    public int generateValue(int min, int max) {
        return (int) (random.nextDouble() * (max - min) + min);
    }

}
