package com.api.utils;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Locale;

/**
 * Class contains all the Utils methods related to Date
 */
public class DateUtils {

    public static String getDateFromDateTime(String inputDateFormat, String outputDateFormat, String date) {
        DateTimeFormatter inputFormatter = DateTimeFormatter.ofPattern(inputDateFormat, Locale.ENGLISH);
        DateTimeFormatter outputFormatter = DateTimeFormatter.ofPattern(outputDateFormat, Locale.ENGLISH);
        LocalDate localDate = LocalDate.parse(date, inputFormatter);
        return outputFormatter.format(localDate);
    }

    public static String getTimeFromDateTime(String inputDateFormat, String outputTimeFormat, String date) {
        return LocalDateTime.parse(date, DateTimeFormatter.ofPattern(inputDateFormat))
                .format(DateTimeFormatter.ofPattern(outputTimeFormat));
    }
}