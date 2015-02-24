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
package com.amalgam.collection;

import java.util.Collection;
import java.util.Iterator;
import java.util.Set;

/**
 * Skeleton class of immutable set.
 * Just wraps the actual map class and all non-destructive method call is delegated to the wrapped object,
 * and all destructive method call throws {@link java.lang.UnsupportedOperationException}.
 * @param <E>
 */
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
        return mSet.containsAll(collection);
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