package com.amalgam.lang;

import com.amalgam.AmalgamTestRunner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

/**
 * Created by Hideyuki.Kikuma on 2014/10/07.
 */
@RunWith(AmalgamTestRunner.class)
public class NumberUtilsTest {
    @Test
    public void testTryParseLong() {
        Assert.assertEquals(Long.valueOf(0), NumberUtils.tryParseLong("0"));
        Assert.assertEquals(Long.valueOf(123), NumberUtils.tryParseLong("123"));
        Assert.assertEquals(Long.valueOf(-123), NumberUtils.tryParseLong("-123"));
        Assert.assertEquals(Long.valueOf(Long.MAX_VALUE), NumberUtils.tryParseLong(String.valueOf(Long.MAX_VALUE)));
        Assert.assertEquals(Long.valueOf(Long.MIN_VALUE), NumberUtils.tryParseLong(String.valueOf(Long.MIN_VALUE)));

        Assert.assertEquals(Long.valueOf(0L), NumberUtils.tryParseLong(null));
        Assert.assertEquals(Long.valueOf(0L), NumberUtils.tryParseLong(String.valueOf("9223372036854775808")));
        Assert.assertEquals(Long.valueOf(0L), NumberUtils.tryParseLong(String.valueOf("-9223372036854775809")));
        Assert.assertEquals(Long.valueOf(0L), NumberUtils.tryParseLong(String.valueOf("-")));
        Assert.assertEquals(Long.valueOf(0L), NumberUtils.tryParseLong(String.valueOf("a")));
    }

    @Test
    public void testTryParseInt() throws Exception {
        Assert.assertEquals(Integer.valueOf(0), NumberUtils.tryParseInt("0"));
        Assert.assertEquals(Integer.valueOf(123), NumberUtils.tryParseInt("123"));
        Assert.assertEquals(Integer.valueOf(-123), NumberUtils.tryParseInt("-123"));
        Assert.assertEquals(Integer.valueOf(Integer.MAX_VALUE), NumberUtils.tryParseInt(String.valueOf(Integer.MAX_VALUE)));
        Assert.assertEquals(Integer.valueOf(Integer.MIN_VALUE), NumberUtils.tryParseInt(String.valueOf(Integer.MIN_VALUE)));

        Assert.assertEquals(Integer.valueOf(0), NumberUtils.tryParseInt(null));
        Assert.assertEquals(Integer.valueOf(0), NumberUtils.tryParseInt(String.valueOf(Long.valueOf(Integer.MAX_VALUE) + 1)));
        Assert.assertEquals(Integer.valueOf(0), NumberUtils.tryParseInt(String.valueOf(Long.valueOf(Integer.MIN_VALUE) - 1)));
        Assert.assertEquals(Integer.valueOf(0), NumberUtils.tryParseInt(String.valueOf("-")));
        Assert.assertEquals(Integer.valueOf(0), NumberUtils.tryParseInt(String.valueOf("a")));
    }

    @Test
    public void testTryParseFloat() throws Exception {
        Assert.assertEquals(Float.valueOf(0), NumberUtils.tryParseFloat("0"));
        Assert.assertEquals(Float.valueOf("1.23f"), NumberUtils.tryParseFloat("1.23f"));
        Assert.assertEquals(Float.valueOf("-1.23f"), NumberUtils.tryParseFloat("-1.23f"));
        Assert.assertEquals(Float.valueOf(Float.MAX_VALUE), NumberUtils.tryParseFloat(String.valueOf(Float.MAX_VALUE)));
        Assert.assertEquals(Float.valueOf(Float.MAX_EXPONENT), NumberUtils.tryParseFloat(String.valueOf(Float.MAX_EXPONENT)));
        Assert.assertEquals(Float.valueOf(Float.MIN_VALUE), NumberUtils.tryParseFloat(String.valueOf(Float.MIN_VALUE)));
        Assert.assertEquals(Float.valueOf(Float.MIN_NORMAL), NumberUtils.tryParseFloat(String.valueOf(Float.MIN_NORMAL)));
        Assert.assertEquals(Float.valueOf(Float.MIN_EXPONENT), NumberUtils.tryParseFloat(String.valueOf(Float.MIN_EXPONENT)));

        // TODO Parameter is a result of when null
//        Assert.assertNull(NumberUtils.tryParseFloat(null));
        Assert.assertEquals(Float.valueOf(0), NumberUtils.tryParseFloat(String.valueOf("3.40282346638528860f+38f")));
        Assert.assertEquals(Float.valueOf(0), NumberUtils.tryParseFloat(String.valueOf("1.40129846432481707f-45f")));
        Assert.assertEquals(Float.valueOf(0), NumberUtils.tryParseFloat(String.valueOf("-")));
        Assert.assertEquals(Float.valueOf(0), NumberUtils.tryParseFloat(String.valueOf("a")));
    }

    @Test
    public void testTryParseDouble() throws Exception {
        Assert.assertEquals(Double.valueOf(0), NumberUtils.tryParseDouble("0"));
        Assert.assertEquals(Double.valueOf("1.23"), NumberUtils.tryParseDouble("1.23"));
        Assert.assertEquals(Double.valueOf("-1.23"), NumberUtils.tryParseDouble("-1.23"));
        Assert.assertEquals(Double.valueOf(Double.MAX_VALUE), NumberUtils.tryParseDouble(String.valueOf(Double.MAX_VALUE)));
        Assert.assertEquals(Double.valueOf(Double.MAX_EXPONENT), NumberUtils.tryParseDouble(String.valueOf(Double.MAX_EXPONENT)));
        Assert.assertEquals(Double.valueOf(Double.MIN_VALUE), NumberUtils.tryParseDouble(String.valueOf(Double.MIN_VALUE)));
        Assert.assertEquals(Double.valueOf(Double.MIN_NORMAL), NumberUtils.tryParseDouble(String.valueOf(Double.MIN_NORMAL)));
        Assert.assertEquals(Double.valueOf(Double.MIN_EXPONENT), NumberUtils.tryParseDouble(String.valueOf(Double.MIN_EXPONENT)));

        // TODO Parameter is a result of when null
//        Assert.assertNull(NumberUtils.tryParseDouble(null));
        Assert.assertEquals(Double.valueOf(0), NumberUtils.tryParseDouble(String.valueOf("3.40282346638528860f+38f")));
        Assert.assertEquals(Double.valueOf(0), NumberUtils.tryParseDouble(String.valueOf("1.40129846432481707f-45f")));
        Assert.assertEquals(Double.valueOf(0), NumberUtils.tryParseDouble(String.valueOf("-")));
        Assert.assertEquals(Double.valueOf(0), NumberUtils.tryParseDouble(String.valueOf("a")));
    }

    @Test
    public void testIsNumber() throws Exception {
        Assert.assertTrue(NumberUtils.isNumber("0"));
        Assert.assertTrue(NumberUtils.isNumber("123"));
        Assert.assertTrue(NumberUtils.isNumber("-123"));
        Assert.assertTrue(NumberUtils.isNumber(String.valueOf(Long.MAX_VALUE)));
        Assert.assertTrue(NumberUtils.isNumber(String.valueOf(Long.MIN_VALUE)));
        Assert.assertTrue(NumberUtils.isNumber(String.valueOf(Double.MAX_VALUE)));
        Assert.assertTrue(NumberUtils.isNumber(String.valueOf(Double.MAX_EXPONENT)));
        Assert.assertTrue(NumberUtils.isNumber(String.valueOf(Double.MIN_VALUE)));
        Assert.assertTrue(NumberUtils.isNumber(String.valueOf(Double.MIN_NORMAL)));
        Assert.assertTrue(NumberUtils.isNumber(String.valueOf(Double.MIN_EXPONENT)));
        Assert.assertFalse(NumberUtils.isNumber(String.valueOf("3.40282346638528860f+38f")));
        Assert.assertFalse(NumberUtils.isNumber(String.valueOf("1.40129846432481707f-45f")));
        Assert.assertFalse(NumberUtils.isNumber(String.valueOf("-")));
        Assert.assertFalse(NumberUtils.isNumber(String.valueOf("a")));

    }

}
