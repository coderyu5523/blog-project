package org.example.blogproject._core.utils;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;

public class DateFormat {
    private static final SimpleDateFormat date = new SimpleDateFormat("yyyy-MM-dd");
    private static final SimpleDateFormat dateTime = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

    public static String formatTimestamp(Timestamp timestamp) {
        return date.format(timestamp);
    }

    public static String formatTimestampWithTime(Timestamp timestamp) {
        return dateTime.format(timestamp);
    }

}
