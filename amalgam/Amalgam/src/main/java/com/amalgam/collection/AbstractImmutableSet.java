package com.amalgam.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

public abstract class AbstractImmutableSet<E> implements Set<E> {
    private final Set<E> mSet;

    public AbstractImmutableSet(Set<E> set) {
        mSet = set;
    }

    /**
     * @hide
     */
    @Override
    public boolean add(E obj) {
        throw new UnsupportedOperationException("this set is immutable");
    }

    /**
     * @hide
     */
    @Override
    public void clear() {
        throw new UnsupportedOperationException("this set is immutable");
    }

    @Override
    public boolean contains(Object obj) {
        return mSet.contains(obj);
    }

    @Override
    public boolean isEmpty() {
        return mSet.isEmpty();
    }

    @Override
    public Iterator<E> iterator() {
        return mSet.iterator();
    }

    /**
     * @hide
     */
    @Override
    public boolean remove(Object o) {
        throw new UnsupportedOperationException("this set is immutable");
    }

    @Override
    public int size() {
        return mSet.size();
    }

    /**
     * @hide
     */
    @Override
    public boolean addAll(Collection<? extends E> collection) {
        throw new UnsupportedOperationException("this set is immutable");
    }

    @Override
    public boolean containsAll(Collection<?> collection) {
        return mSet.contains(collection);
    }

    /**
     * @hide
     */
    @Override
    public boolean removeAll(Collection<?> collection) {
        throw new UnsupportedOperationException("this set is immutable");
    }

    /**
     * @hide
     */
    @Override
    public boolean retainAll(Collection<?> collection) {
        throw new UnsupportedOperationException("this set is immutable");
    }

    @Override
    public Object[] toArray() {
        return mSet.toArray();
    }

    @Override
    public <T> T[] toArray(T[] array) {
        return mSet.toArray(array);
    }
}