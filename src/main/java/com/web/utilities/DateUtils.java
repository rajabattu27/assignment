package com.web.utilities;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Class contains reusable methods related to date and time
 *
 */
public class DateUtils {

    /**
     * Get Current Time Stamp in yyyy-MM-dd HH-mm-ss-SSS format
     *
     * @return current timestamp
     */
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd-HH-mm-ss-SSS");
        Date now = new Date();
        return sdfDate.format(now);
    }
}
