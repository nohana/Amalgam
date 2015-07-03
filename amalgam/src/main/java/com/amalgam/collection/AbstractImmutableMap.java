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
import java.util.Map;
import java.util.Set;

/**
 * Skeleton class of immutable map.
 * Just wraps the actual map class and all non-destructive method call is delegated to the wrapped object,
 * and all destructive method call throws {@link java.lang.UnsupportedOperationException}.
 * @param <K>
 * @param <V>
 */
public abstract class AbstractImmutableMap<K, V> implements Map<K, V> {
    private Map<K, V> mMap;

    public AbstractImmutableMap(Map<K, V> map) {
        mMap = map;
    }

    @Override
    public V get(Object key) {
        return mMap.get(key);
    }

    /**
     * @hide
     */
    @Override
    public V put(K key, V value) {
        throw new UnsupportedOperationException("this map is immutable");
    }

    /**
     * @hide
     */
    @Override
    public void clear() {
        throw new UnsupportedOperationException("this map is immutable");
    }

    @Override
    public boolean containsKey(Object key) {
        return mMap.containsKey(key);
    }

    @Override
    public boolean containsValue(Object value) {
        return mMap.containsValue(value);
    }

    /**
     * @hide
     */
    @Override
    public Set<java.util.Map.Entry<K, V>> entrySet() {
        throw new UnsupportedOperationException("this map is immutable");
    }

    @Override
    public boolean isEmpty() {
        return mMap.isEmpty();
    }

    @Override
    public Set<K> keySet() {
        return new ImmutableHashSet<K>(mMap.keySet());
    }

    /**
     * @hide
     */
    @Override
    public void putAll(Map<? extends K, ? extends V> map) {
        throw new UnsupportedOperationException("this map is immutable");
    }

    /**
     * @hide
     */
    @Override
    public V remove(Object key) {
        throw new UnsupportedOperationException("this map is immutable");
    }

    @Override
    public int size() {
        return mMap.size();
    }

    /**
     * @hide
     */
    @Override
    public Collection<V> values() {
        throw new UnsupportedOperationException("this map is immutable");
    }
}