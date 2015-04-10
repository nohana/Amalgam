/*
 * Copyright (C) 2013 nohana, Inc. All rights reserved.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.amalgam.view;

import android.view.MotionEvent;

/**
 * Utility for the motion event treatment.
 * @author KeithYokoma
 */
@SuppressWarnings("unused") // public APIs
public final class MotionEventUtils {
    private static final float DEFAULT_THRESHOLD = 0.0f;

    /**
     * This is the utility class so do NOT instantiate.
     */
    private MotionEventUtils() {
        throw new AssertionError();
    }

    /**
     * Calculate the horizontal move motion direction.
     * @param e1 start point of the motion.
     * @param e2 end point of the motion.
     * @return the motion direction for the horizontal axis.
     */
    public static MotionDirection getHorizontalMotionDirection(MotionEvent e1, MotionEvent e2) {
        return getHorizontalMotionDirection(e1, e2, DEFAULT_THRESHOLD);
    }

    /**
     * Calculate the horizontal move motion direction.
     * @param e1 start point of the motion.
     * @param e2 end point of the motion.
     * @param threshold threshold to detect the motion.
     * @return the motion direction for the horizontal axis.
     */
    public static MotionDirection getHorizontalMotionDirection(MotionEvent e1, MotionEvent e2, float threshold) {
        float delta = getHorizontalMotionRawDelta(e1, e2);
        return getHorizontalMotionDirection(delta, threshold);
    }

    /**
     * Calculate the horizontal move motion direction.
     * @param delta moved delta.
     * @return the motion direction for the horizontal axis.
     */
    public static MotionDirection getHorizontalMotionDirection(float delta) {
        return getHorizontalMotionDirection(delta, DEFAULT_THRESHOLD);
    }

    /**
     * Calculate the horizontal move motion direction.
     * @param delta moved delta.
     * @param threshold threshold to detect the motion.
     * @return the motion direction for the horizontal axis.
     */
    public static MotionDirection getHorizontalMotionDirection(float delta, float threshold) {
        if (threshold < 0) {
            throw new IllegalArgumentException("threshold should be positive or zero.");
        }
        return delta < -threshold ? MotionDirection.LEFT : delta > threshold ? MotionDirection.RIGHT : MotionDirection.FIX;
    }

    /**
     * Calculate the vertical move motion direction.
     * @param e1 start point of the motion.
     * @param e2 end point of the motion.
     * @return the motion direction for the vertical axis.
     */
    public static MotionDirection getVerticalMotionDirection(MotionEvent e1, MotionEvent e2) {
        return getVerticalMotionDirection(e1, e2, DEFAULT_THRESHOLD);
    }

    /**
     * Calculate the vertical move motion direction.
     * @param e1 start point of the motion.
     * @param e2 end point of the motion.
     * @param threshold threshold to detect the motion.
     * @return the motion direction for the vertical axis.
     */
    public static MotionDirection getVerticalMotionDirection(MotionEvent e1, MotionEvent e2, float threshold) {
        float delta = getVerticalMotionRawDelta(e1, e2);
        return getVerticalMotionDirection(delta, threshold);
    }

    /**
     * Calculate the vertical move motion direction.
     * @param delta moved delta.
     * @return the motion direction for the vertical axis.
     */
    public static MotionDirection getVerticalMotionDirection(float delta) {
        return getVerticalMotionDirection(delta, DEFAULT_THRESHOLD);
    }

    /**
     * Calculate the vertical move motion direction.
     * @param delta moved delta.
     * @param threshold threshold to detect the motion.
     * @return the motion direction for the vertical axis.
     */
    public static MotionDirection getVerticalMotionDirection(float delta, float threshold) {
        if (threshold < 0) {
            throw new IllegalArgumentException("threshold should be positive or zero.");
        }
        return delta < -threshold ? MotionDirection.DOWN : delta > threshold ? MotionDirection.UP : MotionDirection.FIX;
    }

    /**
     * Calculate the move motion delta by raw position.
     * @param e1 start point of the motion.
     * @param e2 end point of the motion.
     * @return the move motion delta of the horizontal axis.
     */
    public static float getHorizontalMotionRawDelta(MotionEvent e1, MotionEvent e2) {
        return e2.getRawX() - e1.getRawX();
    }

    /**
     * Calculate the move motion delta by raw position.
     * @param e1 start point of the motion.
     * @param e2 end point of the motion.
     * @return the move motion delta of the vertical axis..
     */
    public static float getVerticalMotionRawDelta(MotionEvent e1, MotionEvent e2) {
        return e2.getRawY() - e1.getRawY();
    }

    /**
     * Enumeration of the motion direction.
     * @author KeithYokoma
     */
    public static enum MotionDirection {
        /**
         * Moved to Right.
         */
        RIGHT,
        /**
         * Moved to Left.
         */
        LEFT,
        /**
         * Moved to up.
         */
        UP,
        /**
         * Moved to down.
         */
        DOWN,
        /**
         * No movement.
         */
        FIX
    }
}