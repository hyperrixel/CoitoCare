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
 * This file contains constants and static methods code.
 */

package com.fishque.coitocare;

/**
 * Provide container class for static constants and related methods
 * ================================================================
 */
public class CoitoConsts {

    public static final String APP_NAME = "CoitoCare";
    public static final String APP_VERSION = "0.0.1";

    public static final String KEY_NEW_PARTNER_COUNT = "NEW_PARTNER_COUNT";
    public static final String KEY_NEW_PARTNER_ID = "NEW_PARTNER_ID";
    public static final String KEY_NEW_PARTNER_EVENT_ID = "NEW_PARTNER_EVENT_ID";
    public static final String KEY_NEW_PARTNER_EVENT_TIME = "IS_NEW_PARTNER_EVENT_TIME";
    public static final String KEY_PROTECTION_CONDOM = "PROTECTION_CONDOM";
    public static final String KEY_PROTECTION_PEP = "PROTECTION_PEP";
    public static final String KEY_PROTECTION_PREP = "PROTECTION_PREP";

    public static final String QR_MSG_HEADER = "%s %s event_id : ";
    public static final int QR_REQUEST_CODE_PERMISSION = 100;
    public static final String[] QR_SCAN_REQUIRED_PERMISSIONS = new String[] {
            "android.permission.CAMERA",
            "android.permission.WRITE_EXTERNAL_STORAGE"};

    public static final int SWITCH_PROTECTION_CONDOM = 2;
    public static final int SWITCH_PROTECTION_PEP = 4;
    public static final int SWITCH_PROTECTION_PREP = 8;

    public static int counter = 0;

    /**
     * Create a QR code header string
     * ------------------------------
     *
     * @return  String
     *          The QR code header.
     */
    public static String getQrHeader() {

        return String.format(QR_MSG_HEADER, APP_NAME, APP_VERSION);

    }

}
