package com.amalgam.lang;

import com.amalgam.AmalgamTestRunner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Hideyuki.Kikuma on 2014/10/06.
 */
@RunWith(AmalgamTestRunner.class)
public class ConditionUtilsTest {
    @Test
    public void testCheckAllNotNull() {
        Assert.assertTrue(ConditionUtils.checkAllNotNull(new String[]{}));
        Assert.assertFalse(ConditionUtils.checkAllNotNull(new String[]{null, null}));
        Assert.assertFalse(ConditionUtils.checkAllNotNull(new String[]{"", null}));
        Assert.assertFalse(ConditionUtils.checkAllNotNull(new String[]{"foo", null}));
        Assert.assertFalse(ConditionUtils.checkAllNotNull(new String[]{null, ""}));
        Assert.assertFalse(ConditionUtils.checkAllNotNull(new String[]{null, "foo"}));
        Assert.assertTrue(ConditionUtils.checkAllNotNull(new String[]{"", ""}));
        Assert.assertTrue(ConditionUtils.checkAllNotNull(new String[]{"foo", "bar"}));
    }

    @Test
    public void testCheckAllNull() {
        Assert.assertTrue(ConditionUtils.checkAllNull(new String[]{}));
        Assert.assertTrue(ConditionUtils.checkAllNull(new String[]{null, null}));
        Assert.assertFalse(ConditionUtils.checkAllNull(new String[]{"", null}));
        Assert.assertFalse(ConditionUtils.checkAllNull(new String[]{"foo", null}));
        Assert.assertFalse(ConditionUtils.checkAllNull(new String[]{null, ""}));
        Assert.assertFalse(ConditionUtils.checkAllNull(new String[]{null, "foo"}));
        Assert.assertFalse(ConditionUtils.checkAllNull(new String[]{"", ""}));
        Assert.assertFalse(ConditionUtils.checkAllNull(new String[]{"foo", "bar"}));
    }
}
