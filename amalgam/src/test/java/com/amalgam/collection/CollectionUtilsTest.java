package com.amalgam.collection;

import com.amalgam.AmalgamTestRunner;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Hideyuki.Kikuma on 2014/10/10.
 */
@RunWith(AmalgamTestRunner.class)
public class CollectionUtilsTest {
    @Test
    public void testToString() {
        // null
        Assert.assertEquals("null", CollectionUtils.toString(null));

        List<String> stringList = new ArrayList<String>();
        // empty
        Assert.assertEquals("{}", CollectionUtils.toString(stringList));
        stringList.add("foo");
        Assert.assertEquals("{foo}", CollectionUtils.toString(stringList));
        stringList.add("bar");
        Assert.assertEquals("{foo,bar}", CollectionUtils.toString(stringList));
        stringList.add(null);
        Assert.assertEquals("{foo,bar,null}", CollectionUtils.toString(stringList));

        List<Foo> fooList = new ArrayList<Foo>();
        // empty
        Assert.assertEquals("{}", CollectionUtils.toString(fooList));
        fooList.add(new Foo("1"));
        Assert.assertEquals("{foo1}", CollectionUtils.toString(fooList));
        fooList.add(new Foo("2"));
        Assert.assertEquals("{foo1,foo2}", CollectionUtils.toString(fooList));
        fooList.add(null);
        Assert.assertEquals("{foo1,foo2,null}", CollectionUtils.toString(fooList));
    }

    @Test
    public void testGetLastIndex() {
        Assert.assertEquals(0, CollectionUtils.getLastIndex(null));
        List<String> list = new ArrayList<String>();
        Assert.assertEquals(0, CollectionUtils.getLastIndex(list));
        list.add("1");
        Assert.assertEquals(0, CollectionUtils.getLastIndex(list));
        list.add("2");
        Assert.assertEquals(1, CollectionUtils.getLastIndex(list));
        list.add("4");
        Assert.assertEquals(2, CollectionUtils.getLastIndex(list));
    }

    @Test
    public void testIsEmpty() {
        Assert.assertTrue(CollectionUtils.isEmpty(null));
        List<String> list = new ArrayList<String>();
        Assert.assertTrue(CollectionUtils.isEmpty(list));
        list.add("1");
        Assert.assertFalse(CollectionUtils.isEmpty(list));
        list.add("2");
        Assert.assertFalse(CollectionUtils.isEmpty(list));
        list.add("4");
        Assert.assertFalse(CollectionUtils.isEmpty(list));
        list.clear();
        Assert.assertTrue(CollectionUtils.isEmpty(list));
    }

    private class Foo {
        private String mName;

        public Foo(String name) {
            mName = name;
        }

        public String toString() {
            return "foo" + mName;
        }

    }
}
