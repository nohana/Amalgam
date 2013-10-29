package com.amalgam.view;

import android.view.MotionEvent;

/**
 * Utility for the motion event treatment.
 * @author keishin.yokomaku
 */
public final class MotionEventUtils {
    private static final float DEFAULT_THRESHOLD = 0.0f;

    /**
     * This is the utility class so do NOT instantiate.
     */
    private MotionEventUtils() {}

    /**
     *
     * @param e1
     * @param e2
     * @return
     */
    public static final MotionDirection getHorizontalMotionDirection(MotionEvent e1, MotionEvent e2) {
        return getHorizontalMotionDirection(e1, e2, DEFAULT_THRESHOLD);
    }

    /**
     *
     * @param e1
     * @param e2
     * @param threshold
     * @return the motion direction for the horizontal axis.
     */
    public static final MotionDirection getHorizontalMotionDirection(MotionEvent e1, MotionEvent e2, float threshold) {
        float delta = getHorizontalMotionRawDelta(e1, e2);
        return getHorizontalMotionDirection(delta, threshold);
    }

    /**
     *
     * @param delta
     * @return
     */
    public static final MotionDirection getHorizontalMotionDirection(float delta) {
        return getHorizontalMotionDirection(delta, DEFAULT_THRESHOLD);
    }

    /**
     *
     * @param delta
     * @param threshold
     * @return
     */
    public static final MotionDirection getHorizontalMotionDirection(float delta, float threshold) {
        if (threshold < 0) {
            throw new IllegalArgumentException("threshold should be positive or zero.");
        }
        return delta < -threshold ? MotionDirection.LEFT : delta > threshold ? MotionDirection.RIGHT : MotionDirection.FIX;
    }

    /**
     *
     * @param e1
     * @param e2
     * @return
     */
    public static final MotionDirection getVerticalMotionDirection(MotionEvent e1, MotionEvent e2) {
        return getVerticalMotionDirection(e1, e2, DEFAULT_THRESHOLD);
    }

    /**
     *
     * @param e1
     * @param e2
     * @param threshold
     * @return the motion direction for the vertical axis.
     */
    public static final MotionDirection getVerticalMotionDirection(MotionEvent e1, MotionEvent e2, float threshold) {
        float delta = getVerticalMotionRawDelta(e1, e2);
        return getVerticalMotionDirection(delta, threshold);
    }

    /**
     *
     * @param delta
     * @return
     */
    public static final MotionDirection getVerticalMotionDirection(float delta) {
        return getVerticalMotionDirection(delta, DEFAULT_THRESHOLD);
    }

    /**
     *
     * @param delta
     * @param threshold
     * @return
     */
    public static final MotionDirection getVerticalMotionDirection(float delta, float threshold) {
        if (threshold < 0) {
            throw new IllegalArgumentException("threshold should be positive or zero.");
        }
        return delta < -threshold ? MotionDirection.DOWN : delta > threshold ? MotionDirection.UP : MotionDirection.FIX;
    }

    /**
     *
     * @param e1
     * @param e2
     * @return
     */
    public static final float getHorizontalMotionRawDelta(MotionEvent e1, MotionEvent e2) {
        return e2.getRawX() - e1.getRawX();
    }

    /**
     *
     * @param e1
     * @param e2
     * @return
     */
    public static final float getVerticalMotionRawDelta(MotionEvent e1, MotionEvent e2) {
        return e2.getRawY() - e1.getRawY();
    }

    /**
     * Enumeration of the motion direction.
     * @author keishin.yokomaku
     */
    public static enum MotionDirection {
        RIGHT, LEFT, UP, DOWN, FIX;
    }
}