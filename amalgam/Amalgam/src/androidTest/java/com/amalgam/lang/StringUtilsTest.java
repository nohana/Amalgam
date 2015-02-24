package com.amalgam.lang;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hideyuki.Kikuma on 2014/10/07.
 */
@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 18)
public class StringUtilsTest {

    @Test
    public void testByteToHex() {
        Assert.assertNull(StringUtils.byteToHex(null));
        Assert.assertEquals("", StringUtils.byteToHex(new byte[]{}));
        Assert.assertEquals("010203", StringUtils.byteToHex(new byte[]{0x1, 0x2, 0x3}));
        Assert.assertEquals("7F80", StringUtils.byteToHex(new byte[]{Byte.MAX_VALUE, Byte.MIN_VALUE}));
        Assert.assertEquals("1F2A30", StringUtils.byteToHex(new byte[]{0x1f, 0x2a, 0x30}));
    }

    @Test
    public void testReplaceLineBreaksWithSpace() {
        Assert.assertNull(StringUtils.replaceLineBreaksWithSpace(null));
        Assert.assertEquals("", StringUtils.replaceLineBreaksWithSpace(""));
        Assert.assertEquals("foobar", StringUtils.replaceLineBreaksWithSpace("foobar"));
        Assert.assertEquals("foo bar", StringUtils.replaceLineBreaksWithSpace("foo bar"));
        Assert.assertEquals("foo bar", StringUtils.replaceLineBreaksWithSpace("foo\nbar"));
        Assert.assertEquals("foo  bar", StringUtils.replaceLineBreaksWithSpace("foo\n\nbar"));
        Assert.assertEquals("foo bar", StringUtils.replaceLineBreaksWithSpace("foo\rbar"));
        Assert.assertEquals("foo bar", StringUtils.replaceLineBreaksWithSpace("foo\r\nbar"));
        Assert.assertEquals("foo bar ", StringUtils.replaceLineBreaksWithSpace("foo\r\nbar\n"));
        Assert.assertEquals(" foo bar", StringUtils.replaceLineBreaksWithSpace("\rfoo\nbar"));
        Assert.assertEquals(" foo bar ", StringUtils.replaceLineBreaksWithSpace("\rfoo bar\n"));
    }

    @Test
    public void testCollapseLineBreaks() {
        Assert.assertNull(StringUtils.collapseLineBreaks(null));
        Assert.assertEquals("", StringUtils.collapseLineBreaks(""));
        Assert.assertEquals("foobar", StringUtils.collapseLineBreaks("foobar"));
        Assert.assertEquals("foo bar", StringUtils.collapseLineBreaks("foo bar"));
        Assert.assertEquals("foobar", StringUtils.collapseLineBreaks("foo\nbar"));
        Assert.assertEquals("foobar", StringUtils.collapseLineBreaks("foo\n\nbar"));
        Assert.assertEquals("foobar", StringUtils.collapseLineBreaks("foo\rbar"));
        Assert.assertEquals("foobar", StringUtils.collapseLineBreaks("foo\r\nbar"));
        Assert.assertEquals("foobar", StringUtils.collapseLineBreaks("foo\r\nbar\n"));
        Assert.assertEquals("foobar", StringUtils.collapseLineBreaks("\rfoo\nbar"));
        Assert.assertEquals("foo bar", StringUtils.collapseLineBreaks("\rfoo bar\n"));
    }

    @Test
    public void testReplaceLineBreaks() {
        Assert.assertNull(StringUtils.replaceLineBreaks(null, "abc"));
        Assert.assertEquals("", StringUtils.replaceLineBreaks("", "abc"));
        Assert.assertEquals("foobar", StringUtils.replaceLineBreaks("foobar", "abc"));
        Assert.assertEquals("foo bar", StringUtils.replaceLineBreaks("foo bar", "abc"));
        Assert.assertEquals("fooabcbar", StringUtils.replaceLineBreaks("foo\nbar", "abc"));
        Assert.assertEquals("fooabcabcbar", StringUtils.replaceLineBreaks("foo\n\nbar", "abc"));
        Assert.assertEquals("fooabcbar", StringUtils.replaceLineBreaks("foo\rbar", "abc"));
        Assert.assertEquals("fooabcbar", StringUtils.replaceLineBreaks("foo\r\nbar", "abc"));
        Assert.assertEquals("fooabcbarabc", StringUtils.replaceLineBreaks("foo\r\nbar\n", "abc"));
        Assert.assertEquals("abcfooabcbar", StringUtils.replaceLineBreaks("\rfoo\nbar", "abc"));
        Assert.assertEquals("abcfoo barabc", StringUtils.replaceLineBreaks("\rfoo bar\n", "abc"));
    }

    @Test
    public void testRemoveWhiteSpaces() {
        Assert.assertNull(StringUtils.removeWhiteSpaces(null));
        Assert.assertEquals("", StringUtils.removeWhiteSpaces(""));
        Assert.assertEquals("foobar", StringUtils.removeWhiteSpaces("foobar"));
        Assert.assertEquals("foobar", StringUtils.removeWhiteSpaces("foo bar"));
        Assert.assertEquals("foobar", StringUtils.removeWhiteSpaces("foo         bar"));
        Assert.assertEquals("foobar", StringUtils.removeWhiteSpaces("   foo         bar  "));
        Assert.assertEquals("foobar", StringUtils.removeWhiteSpaces("foo\nbar"));
        Assert.assertEquals("foobar", StringUtils.removeWhiteSpaces("foo\n\nbar"));
        Assert.assertEquals("foobar", StringUtils.removeWhiteSpaces("foo\rbar"));
        Assert.assertEquals("foobar", StringUtils.removeWhiteSpaces("foo\r\n bar"));
        Assert.assertEquals("foobar", StringUtils.removeWhiteSpaces("foo\r\nbar\n"));
        Assert.assertEquals("foobar", StringUtils.removeWhiteSpaces("\rfoo\n bar"));
        Assert.assertEquals("foobar", StringUtils.removeWhiteSpaces("\rfoo bar\n"));
    }

    @Test
    public void testTryTrim() {
        Assert.assertNull(StringUtils.tryTrim(null));
        Assert.assertEquals("", StringUtils.tryTrim(""));
        Assert.assertEquals("foobar", StringUtils.tryTrim("foobar"));
        Assert.assertEquals("foo bar", StringUtils.tryTrim("foo bar"));
        Assert.assertEquals("foo         bar", StringUtils.tryTrim("foo         bar"));
        Assert.assertEquals("foo         bar", StringUtils.tryTrim("   foo         bar  "));
        Assert.assertEquals("foo\nbar", StringUtils.tryTrim("foo\nbar"));
        Assert.assertEquals("foo\n\nbar", StringUtils.tryTrim("foo\n\nbar"));
        Assert.assertEquals("foo\rbar", StringUtils.tryTrim("foo\rbar"));
        Assert.assertEquals("foo\r\n bar", StringUtils.tryTrim("foo\r\n bar"));
        Assert.assertEquals("foo\r\nbar", StringUtils.tryTrim("foo\r\nbar\n"));
        Assert.assertEquals("foo\n bar", StringUtils.tryTrim("\rfoo\n bar"));
        Assert.assertEquals("foo bar", StringUtils.tryTrim("\rfoo bar\n"));
    }

    @Test
    public void testGetLevenshteinDistance() {
        try {
            StringUtils.getLevenshteinDistance(null, null);
            Assert.fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            StringUtils.getLevenshteinDistance("", null);
            Assert.fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            StringUtils.getLevenshteinDistance(null, "");
            Assert.fail();
        } catch (IllegalArgumentException e) {
        }
        try {
            StringUtils.getLevenshteinDistance("foo", null);
            Assert.fail();
        } catch (IllegalArgumentException e) {
        }
        Assert.assertEquals(3, StringUtils.getLevenshteinDistance("foo", ""));
        try {
            StringUtils.getLevenshteinDistance(null, "bar");
            Assert.fail();
        } catch (IllegalArgumentException e) {
        }
        Assert.assertEquals(0, StringUtils.getLevenshteinDistance("", ""));
        Assert.assertEquals(3, StringUtils.getLevenshteinDistance("", "bar"));
        Assert.assertEquals(3, StringUtils.getLevenshteinDistance("foo", "bar"));
        Assert.assertEquals(4, StringUtils.getLevenshteinDistance("foo1", "bar"));
        Assert.assertEquals(4, StringUtils.getLevenshteinDistance("foo", "bar1"));
    }

    @Test
    public void testJoinWithObjectArray() {
        Assert.assertNull(StringUtils.join(null, ' '));
        Assert.assertEquals(" ", StringUtils.join(new String[]{null, null}, ' '));
        Assert.assertEquals("", StringUtils.join(new String[]{}, ' '));
        Assert.assertEquals("", StringUtils.join(new String[]{""}, ' '));
        Assert.assertEquals(" ", StringUtils.join(new String[]{"", ""}, ' '));
        Assert.assertEquals("  ", StringUtils.join(new String[]{"", "", ""}, ' '));
        Assert.assertEquals("foo bar buzz", StringUtils.join(new String[]{"foo", "bar", "buzz"}, ' '));
        Assert.assertEquals("foo-bar-buzz", StringUtils.join(new String[]{"foo", "bar", "buzz"}, '-'));
        Assert.assertEquals("foo-bar-buzz", StringUtils.join(new Foo[]{new Foo("foo"), new Foo("bar"), new Foo("buzz")}, '-'));
    }

    @Test
    public void testJoinWithStringIterator() {
        List<String> list = new ArrayList<String>();
        Assert.assertEquals("", StringUtils.join(list.iterator(), ""));
        Assert.assertEquals("", StringUtils.join(list.iterator(), " "));
        list.add("");
        Assert.assertEquals("", StringUtils.join(list.iterator(), ""));
        Assert.assertEquals("", StringUtils.join(list.iterator(), " "));
        list.add("foo");
        Assert.assertEquals("foo", StringUtils.join(list.iterator(), ""));
        Assert.assertEquals(" foo", StringUtils.join(list.iterator(), " "));
        list.add("bar");
        Assert.assertEquals("foobar", StringUtils.join(list.iterator(), ""));
        Assert.assertEquals(" foo bar", StringUtils.join(list.iterator(), " "));
    }

    @Test
    public void testJoinWithFooIterator() {
        List<Foo> list = new ArrayList<Foo>();
        Assert.assertEquals("", StringUtils.join(list.iterator(), ""));
        Assert.assertEquals("", StringUtils.join(list.iterator(), " "));
        list.add(new Foo(""));
        Assert.assertEquals("", StringUtils.join(list.iterator(), ""));
        Assert.assertEquals("", StringUtils.join(list.iterator(), " "));
        list.add(new Foo("foo"));
        Assert.assertEquals("foo", StringUtils.join(list.iterator(), ""));
        Assert.assertEquals(" foo", StringUtils.join(list.iterator(), " "));
        list.add(new Foo("bar"));
        Assert.assertEquals("foobar", StringUtils.join(list.iterator(), ""));
        Assert.assertEquals(" foo bar", StringUtils.join(list.iterator(), " "));
    }

    @Test
    public void testJoinWithStringCollection() {
        List<String> list = new ArrayList<String>();
        Assert.assertEquals("", StringUtils.join(list, ""));
        Assert.assertEquals("", StringUtils.join(list, " "));
        list.add("");
        Assert.assertEquals("", StringUtils.join(list, ""));
        Assert.assertEquals("", StringUtils.join(list, " "));
        list.add("foo");
        Assert.assertEquals("foo", StringUtils.join(list, ""));
        Assert.assertEquals(" foo", StringUtils.join(list, " "));
        list.add("bar");
        Assert.assertEquals("foobar", StringUtils.join(list, ""));
        Assert.assertEquals(" foo bar", StringUtils.join(list, " "));
    }

    @Test
    public void testJoinWithFooCollection() {
        List<Foo> list = new ArrayList<Foo>();
        Assert.assertEquals("", StringUtils.join(list, ""));
        Assert.assertEquals("", StringUtils.join(list, " "));
        list.add(new Foo(""));
        Assert.assertEquals("", StringUtils.join(list, ""));
        Assert.assertEquals("", StringUtils.join(list, " "));
        list.add(new Foo("foo"));
        Assert.assertEquals("foo", StringUtils.join(list, ""));
        Assert.assertEquals(" foo", StringUtils.join(list, " "));
        list.add(new Foo("bar"));
        Assert.assertEquals("foobar", StringUtils.join(list, ""));
        Assert.assertEquals(" foo bar", StringUtils.join(list, " "));
    }

    private class Foo {
        private String name;

        public Foo(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return name;
        }
    }
}
