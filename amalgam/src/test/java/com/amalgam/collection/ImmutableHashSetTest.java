package com.amalgam.collection;

import com.amalgam.AmalgamTestRunner;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;

/**
 * Created by Hideyuki.Kikuma on 2014/10/10.
 */
@RunWith(AmalgamTestRunner.class)
public class ImmutableHashSetTest {
    private static final String VALUE1 = "foo";
    private static final String VALUE2 = "bar";
    private static final String NOT_VALUE = "test";
    private ImmutableHashSet<String> mImmutableHashSet;

    @Before
    public void setUp() {
        HashSet<String> set = new LinkedHashSet<>();
        set.add(VALUE1);
        set.add(VALUE2);
        mImmutableHashSet = new ImmutableHashSet<String>(set);
    }

    @Test
    public void testAdd() {
        try {
            mImmutableHashSet.add("test");
            Assert.fail();
        } catch (UnsupportedOperationException e) {
        }
    }

    @Test
    public void testClear() {
        try {
            mImmutableHashSet.clear();
            Assert.fail();
        } catch (UnsupportedOperationException e) {
        }
    }

    @Test
    public void testContains() {
        Assert.assertTrue(mImmutableHashSet.contains(VALUE1));
        Assert.assertTrue(mImmutableHashSet.contains(VALUE2));
        Assert.assertFalse(mImmutableHashSet.contains(NOT_VALUE));
    }

    @Test
    public void testIsEmpty() {
        Assert.assertFalse(mImmutableHashSet.isEmpty());
        ImmutableHashSet<String> emptySet = new ImmutableHashSet<String>(new HashSet<String>());
        Assert.assertTrue(emptySet.isEmpty());
    }

    @Test
    public void testIterator() {
        Iterator<String> iterator = mImmutableHashSet.iterator();
        Assert.assertTrue(iterator.hasNext());
        String value1 = iterator.next();
        //todo test value1
        Assert.assertTrue(iterator.hasNext());
        String value2 = iterator.next();
        //todo test value2
        Assert.assertFalse(iterator.hasNext());
    }

    @Test
    public void testRemove() {
        try {
            mImmutableHashSet.remove(VALUE1);
            Assert.fail();
        } catch (UnsupportedOperationException e) {
        }
        try {
            mImmutableHashSet.remove(NOT_VALUE);
            Assert.fail();
        } catch (UnsupportedOperationException e) {
        }
    }

    @Test
    public void testSize() {
        Assert.assertEquals(2, mImmutableHashSet.size());
    }

    @Test
    public void testAddAll() {
        Collection<String> collection = new ArrayList<String>();
        try {
            mImmutableHashSet.addAll(collection);
            Assert.fail();
        } catch (UnsupportedOperationException e) {
        }
        collection.add("aaa");
        try {
            mImmutableHashSet.addAll(collection);
            Assert.fail();
        } catch (UnsupportedOperationException e) {
        }
    }

    @Test
    public void testContainsAll() {
        Collection<String> collection = new ArrayList<String>();
        Assert.assertTrue(mImmutableHashSet.containsAll(collection));
        collection.add(VALUE1);
        Assert.assertTrue(mImmutableHashSet.containsAll(collection));
        collection.add(NOT_VALUE);
        Assert.assertFalse(mImmutableHashSet.containsAll(collection));
    }

    @Test
    public void testRemoveAll() {
        Collection<String> collection = new ArrayList<String>();
        try {
            mImmutableHashSet.removeAll(collection);
            Assert.fail();
        } catch (UnsupportedOperationException e) {
        }
        collection.add(VALUE1);
        try {
            mImmutableHashSet.removeAll(collection);
            Assert.fail();
        } catch (UnsupportedOperationException e) {
        }
    }

    @Test
    public void testRetainAll() {
        Collection<String> collection = new ArrayList<String>();
        try {
            mImmutableHashSet.retainAll(collection);
            Assert.fail();
        } catch (UnsupportedOperationException e) {
        }
        collection.add(VALUE1);
        try {
            mImmutableHashSet.retainAll(collection);
            Assert.fail();
        } catch (UnsupportedOperationException e) {
        }
    }

    @Test
    public void testToArray() {
        Object[] array = mImmutableHashSet.toArray();
        Assert.assertEquals(2, array.length);
        //todo test contents
    }

    @Test
    public void testToArrayWithType() {
        String[] array = mImmutableHashSet.toArray(new String[]{});
        Assert.assertEquals(2, array.length);
        //todo test contents
    }
}
