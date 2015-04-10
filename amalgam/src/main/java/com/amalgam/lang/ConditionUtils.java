package com.amalgam.lang;

/**
 * @author KeithYokoma
 */
@SuppressWarnings("unused")
public final class ConditionUtils {
    private ConditionUtils() {
        throw new AssertionError();
    }

    public static <T> boolean checkAllNotNull(T... objs) {
        for (T t : objs) {
            if (t == null) {
                return false;
            }
        }
        return true;
    }

    public static <T> boolean checkAllNull(T... objs) {
        for (T t : objs) {
            if (t != null) {
                return false;
            }
        }
        return true;
    }
}
