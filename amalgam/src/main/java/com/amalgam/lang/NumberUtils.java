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
		try {
			return Long.parseLong(number);
		} catch (NumberFormatException e) {
			Log.i(TAG, "cannot convert the string to the number");
			return null;
		}
	}

	public static Integer tryParseInt(String number) {
		try {
			return Integer.parseInt(number);
		} catch (NumberFormatException e) {
			Log.i(TAG, "cannot convert the string to the number");
			return null;
		}
	}

	public static Float tryParseFloat(String number) {
		try {
			return Float.parseFloat(number);
		} catch (NumberFormatException e) {
			Log.i(TAG, "cannot convert the string to the number");
			return null;
		}
	}

	public static Double tryParseDouble(String number) {
		try {
			return Double.parseDouble(number);
		} catch (NumberFormatException e) {
			Log.i(TAG, "cannot convert the string to the number");
			return null;
		}
	}

	public static boolean isNumber(String number) {
		return tryParseInt(number) != null || tryParseLong(number) != null ||
				tryParseFloat(number) != null || tryParseDouble(number) != null;
	}
}