package com.adobe.aem.commons.assetshare.util.impl;

import org.apache.commons.lang3.StringUtils;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateTimeExpressionEvaluator {
    public static final String VAR_DATE_YEAR = "${date.year}";
    public static final String VAR_DATE_MONTH = "${date.month}";
    public static final String VAR_DATE_MONTH_NAME = "${date.monthName}";
    public static final String VAR_DATE_DAY = "${date.day}";
    public static final String VAR_DATE_DAY_NAME = "${date.dayName}";
    public static final String VAR_TIME_HOUR_24 = "${time.hour24}";
    public static final String VAR_TIME_HOUR_12 = "${time.hour12}";
    public static final String VAR_TIME_MINUTE = "${time.minute}";
    public static final String VAR_TIME_AM_PM = "${time.ampm}";

    private static final DateTimeFormatter year = DateTimeFormatter.ofPattern("yyyy");
    private static final DateTimeFormatter month = DateTimeFormatter.ofPattern("MM");
    private static final DateTimeFormatter monthName = DateTimeFormatter.ofPattern("MMM");
    private static final DateTimeFormatter day = DateTimeFormatter.ofPattern("dd");
    private static final DateTimeFormatter dayName = DateTimeFormatter.ofPattern("EEE");

    private static final DateTimeFormatter hour24 = DateTimeFormatter.ofPattern("HH");
    private static final DateTimeFormatter hour12 = DateTimeFormatter.ofPattern("hh");
    private static final DateTimeFormatter minute = DateTimeFormatter.ofPattern("mm");
    private static final DateTimeFormatter ampm = DateTimeFormatter.ofPattern("a");

    public String evaluateDateTimeExpressions(String expression, ZonedDateTime zonedDateTime) {
        expression = StringUtils.replace(expression, VAR_DATE_YEAR, zonedDateTime.format(year));
        expression = StringUtils.replace(expression, VAR_DATE_MONTH, zonedDateTime.format(month));
        expression = StringUtils.replace(expression, VAR_DATE_MONTH_NAME, zonedDateTime.format(monthName));
        expression = StringUtils.replace(expression, VAR_DATE_DAY, zonedDateTime.format(day));
        expression = StringUtils.replace(expression, VAR_DATE_DAY_NAME, zonedDateTime.format(dayName));
        expression = StringUtils.replace(expression, VAR_TIME_HOUR_24, zonedDateTime.format(hour24));
        expression = StringUtils.replace(expression, VAR_TIME_HOUR_12, zonedDateTime.format(hour12));
        expression = StringUtils.replace(expression, VAR_TIME_MINUTE, zonedDateTime.format(minute));
        expression = StringUtils.replace(expression, VAR_TIME_AM_PM, zonedDateTime.format(ampm));

        return expression;
    }
}
