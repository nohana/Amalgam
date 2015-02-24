package com.amalgam.collection;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;

import java.util.HashMap;
import java.util.Set;

/**
 * Created by Hideyuki.Kikuma on 2014/10/10.
 */
@RunWith(RobolectricTestRunner.class)
@Config(emulateSdk = 18)
public class ImmutableHashMapTest {

    private static final String KEY = "foo";
    private static final String NOT_KEY = "test";
    private static final String VALUE = "bar";
    private ImmutableHashMap<String, String> mImmutableHashMap;

    @Before
    public void setUp() {
        HashMap<String, String> hashMap;
        hashMap = new HashMap<String, String>();
        hashMap.put(KEY, VALUE);
        mImmutableHashMap = new ImmutableHashMap<String, String>(hashMap);
    }

    @Test
    public void testGet() {
        Assert.assertEquals(VALUE, mImmutableHashMap.get(KEY));
        Assert.assertNull(mImmutableHashMap.get(NOT_KEY));
    }

    @Test
    public void testPut() {
        try {
            mImmutableHashMap.put(KEY, VALUE);
            Assert.fail();
        } catch (UnsupportedOperationException e) {
        }
        try {
            mImmutableHashMap.put(NOT_KEY, VALUE);
            Assert.fail();
        } catch (UnsupportedOperationException e) {
        }
    }

    @Test
    public void testClear() {
        try {
            mImmutableHashMap.clear();
            Assert.fail();
        } catch (UnsupportedOperationException e) {
        }

    }

    @Test
    public void testContainsKey() {
        Assert.assertTrue(mImmutableHashMap.containsKey(KEY));
        Assert.assertFalse(mImmutableHashMap.containsKey(NOT_KEY));
    }

    @Test
    public void testContainsValue() {
        Assert.assertTrue(mImmutableHashMap.containsValue(VALUE));
        Assert.assertFalse(mImmutableHashMap.containsValue(""));
    }

    @Test
    public void testEntrySet() {
        try {
            mImmutableHashMap.entrySet();
            Assert.fail();
        } catch (UnsupportedOperationException e) {
        }
    }

    @Test
    public void testIsEmpty() {
        Assert.assertFalse(mImmutableHashMap.isEmpty());
        ImmutableHashMap<String, String> emptyMap = new ImmutableHashMap<String, String>(new HashMap<String, String>());
        Assert.assertTrue(emptyMap.isEmpty());
    }

    @Test
    public void testKeyset() {
        Set<String> keys = mImmutableHashMap.keySet();
        Assert.assertEquals(1, keys.size());
        keys.contains(KEY);
    }

    @Test
    public void testPutAll() {
        try {
            mImmutableHashMap.putAll(new HashMap<String, String>());
            Assert.fail();
        } catch (UnsupportedOperationException e) {
        }
    }

    @Test
    public void testRemove() {
        try {
            mImmutableHashMap.remove(KEY);
            Assert.fail();
        } catch (UnsupportedOperationException e) {
        }
    }

    @Test
    public void testSize() {
        Assert.assertEquals(1, mImmutableHashMap.size());
    }

    @Test
    public void testValues() {
        try {
            mImmutableHashMap.values();
            Assert.fail();
        } catch (UnsupportedOperationException e) {
        }
    }
}
