package com.amalgam.lang;

/**
 * @author KeithYokoma
 */
@SuppressWarnings("unused")
public final class ArrayUtils {
    public static final String TAG = ArrayUtils.class.getSimpleName();

    private ArrayUtils() {
        throw new AssertionError();
    }

    public static <T> T[] asArray(T... objs) {
        return objs;
    }

    public static boolean[] asArray(boolean... booleans) {
        return booleans;
    }

    public static byte[] asArray(byte... bytes) {
        return bytes;
    }

    public static short[] asArray(short... shorts) {
        return shorts;
    }

    public static char[] asArray(char... chars) {
        return chars;
    }

    public static int[] asArray(int... ints) {
        return ints;
    }

    public static long[] asArray(long... longs) {
        return longs;
    }

    public static float[] asArray(float... floats) {
        return floats;
    }

    public static double[] asArray(double... doubles) {
        return doubles;
    }
}
