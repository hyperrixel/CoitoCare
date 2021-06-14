/**
 * CoitoCare
 * =========
 * Complete solution for sexually active people to provide safety from
 * sexually transmitted disease or infection.
 *
 * @author     Axel Ország-Krisz Dr.
 * @author     Richárd Ádám Vécsey Dr.
 *
 * @copyright  (c) 2021 by Axel Ország-Krisz Dr. and Richárd Ádám Vécsey Dr.
 * @copyright  All rights reserved.
 * @copyright  ATTENTION: This code is not open source.
 *
 * This file contains tools alike code.
 */

package com.fishque.coitocare;

import java.util.Random;

/**
 * Provide container class for tool functions
 * ==========================================
 */
public class CoitoTools {

    private static final int GENERATOR_RANGE = 26;
    private static final int GENERATOR_START_ASCII = 97;
    private static final int DEFAULT_CODE_LENGTH = 64;

    /**
     * Generate event ID number with standard length
     * ---------------------------------------------
     *
     * @return  String
     *          The generated event ID.
     */
    public static String generateEventCode() {

        return generateEventCode(DEFAULT_CODE_LENGTH);

    }

    /**
     * Generate event ID number with given length
     * ------------------------------------------
     *
     * @param   int codeLength
     *          Length of the event ID to generate.
     *
     * @return  String
     *          The generated event ID.
     */
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
