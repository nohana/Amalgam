package com.amalgam.lang;

import android.util.Log;

/**
 * @author KeishinYokomaku
 */
@SuppressWarnings("unused") // public APIs
public final class NumberUtils {
	public static final String TAG = NumberUtils.class.getSimpleName();

	private NumberUtils() {
		throw new AssertionError();
	}

	public static Long tryParseLong(String number) {
		return tryParseLong(number, 0L);
	}

	public static Long tryParseLong(String number, Long fallback) {
		try {
			return Long.parseLong(number);
		} catch (NumberFormatException e) {
			Log.i(TAG, "cannot convert the string to the number");
			return fallback;
		}
	}

	public static Integer tryParseInt(String number) {
		return tryParseInt(number, 0);
	}

	public static Integer tryParseInt(String number, Integer fallback) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			Log.i(TAG, "cannot convert the string to the number");
			return fallback;
		}
	}

	public static Float tryParseFloat(String number) {
		return tryParseFloat(number, 0.f);
	}

	public static Float tryParseFloat(String number, Float fallback) {
		try {
			return Float.parseFloat(number);
		} catch (NumberFormatException e) {
			Log.i(TAG, "cannot convert the string to the number");
			return fallback;
		}
	}

	public static Double tryParseDouble(String number) {
		return tryParseDouble(number, 0.d);
	}

	public static Double tryParseDouble(String number, Double fallback) {
		try {
			return Double.parseDouble(number);
		} catch (NumberFormatException e) {
			Log.i(TAG, "cannot convert the string to the number");
			return fallback;
		}
	}

	public static boolean isNumber(String number) {
		return tryParseInt(number, null) != null || tryParseLong(number, null) != null ||
				tryParseFloat(number, null) != null || tryParseDouble(number, null) != null;
	}
}