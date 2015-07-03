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

import java.util.Map;
import java.util.WeakHashMap;

/**
 *  ImmutableWeakHashMap
 *  The purpose of this class that define immutable this class instance for clarity.
 *
 * @param <K>
 * @param <V>
 */
public class ImmutableWeakHashMap<K, V> extends AbstractImmutableMap<K, V> {
    public ImmutableWeakHashMap(Map<K, V> map) {
        super(new WeakHashMap<K, V>(map));
    }
}
