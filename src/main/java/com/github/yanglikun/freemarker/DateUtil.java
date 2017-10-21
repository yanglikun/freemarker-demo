package com.github.yanglikun.freemarker;

import org.apache.commons.lang3.StringUtils;
import org.joda.time.DateTime;

public class DateUtil {

    public static String getDateAsString(String pattern) {
        return DateTime.now().toString(StringUtils.isEmpty(pattern) ? "yyy-MM-dd HH:mm:ss" : pattern);
    }

}
