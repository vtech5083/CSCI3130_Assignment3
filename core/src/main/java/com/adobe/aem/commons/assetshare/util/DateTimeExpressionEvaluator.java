package com.adobe.aem.commons.assetshare.util;

import org.osgi.annotation.versioning.ProviderType;

import java.time.ZonedDateTime;

@ProviderType
public interface DateTimeExpressionEvaluator {
    String VAR_DATE_YEAR = "${year}";
    String VAR_DATE_MONTH = "${month}";
    String VAR_DATE_MONTH_NAME = "${month.name}";
    String VAR_DATE_DAY = "${day}";
    String VAR_DATE_DAY_NAME = "${day.name}";
    String VAR_TIME_HOUR_24 = "${hour.24}";
    String VAR_TIME_HOUR_12 = "${hour.12}";
    String VAR_TIME_MINUTE = "${minute}";
    String VAR_TIME_AM_PM = "${am.pm}";

    String evaluateDateTimeExpressions(String expression, ZonedDateTime zonedDateTime);
}
