package com.amalgam.collection;

import java.util.HashSet;
import java.util.Set;

public class ImmutableHashSet<E> extends AbstractImmutableSet<E> {
    public ImmutableHashSet(Set<E> set) {
        super(new HashSet<E>(set));
    }
}