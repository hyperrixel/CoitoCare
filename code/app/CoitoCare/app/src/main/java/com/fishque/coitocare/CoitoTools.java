package com.fishque.coitocare;

import java.util.Random;

public class CoitoTools {

    private static final int GENERATOR_RANGE = 26;
    private static final int GENERATOR_START_ASCII = 97;
    private static final int DEFAULT_CODE_LENGTH = 64;

    public static String generateEventCode() {

        return generateEventCode(DEFAULT_CODE_LENGTH);

    }

    public static String generateEventCode(int codeLength) {

        Random random = new Random();
        StringBuilder builder = new StringBuilder();
        char nextChar;

        for (int i = 0; i < codeLength; i++) {

            nextChar = (char) (random.nextInt(GENERATOR_RANGE) + GENERATOR_START_ASCII);
            builder.append(nextChar);

        }

        return builder.toString();

    }

}
