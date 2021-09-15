package com.web.utilities;

import java.util.Random;

/**
 * Contains utility methods
 *
 */
public class Utils {

    /**
     * Returns the random number between the min and max number
     * @param min minimum range 0
     * @param max maximum int range
     * @return random value
     */
    public static String getRandomNumber(int min, int max) {
        Random random = new Random();
        int number = random.nextInt((max - min) + 1) + min;
        return String.valueOf(number);
    }

    public static String getResourceFilePath() {
        return System.getProperty("user.dir") + "\\src\\test\\resources\\";
    }
}
