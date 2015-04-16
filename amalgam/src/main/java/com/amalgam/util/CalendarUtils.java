package com.amalgam.util;

import java.util.Calendar;

/**
 * @author KeithYokoma
 */
@SuppressWarnings("unused")
public final class CalendarUtils {
    public static final int TIME_OF_DAY_SECOND = 1000;
    public static final int TIME_OF_DAY_MINUTE = TIME_OF_DAY_SECOND * 60;
    public static final int TIME_OF_DAY_HOUR = TIME_OF_DAY_MINUTE * 60;
    public static final int TIME_OF_DAY = TIME_OF_DAY_HOUR * 24;

    private CalendarUtils() {
        throw new AssertionError();
    }

    public static int getTimeOfDay(long now) {
        Calendar cal = Calendar.getInstance();
        cal.setTimeInMillis(now);
        return getTimeOfDay(cal);
    }

    public static int getTimeOfDay(Calendar cal) {
        int hour = cal.get(Calendar.HOUR_OF_DAY);
        int minutes = cal.get(Calendar.MINUTE);
        int seconds = cal.get(Calendar.SECOND);
        int milliSeconds = cal.get(Calendar.MILLISECOND);
        return hour * TIME_OF_DAY_HOUR +
                minutes * TIME_OF_DAY_MINUTE +
                seconds * TIME_OF_DAY_SECOND +
                milliSeconds;
    }

    public static int getTimeOfDayDiff(int a, int b) {
        if (a < b)
            return Math.min(b - a, a + TIME_OF_DAY_HOUR - b);
        return Math.min(a - b, b + TIME_OF_DAY_HOUR - a);
    }
}
