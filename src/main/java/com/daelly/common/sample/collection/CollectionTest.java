package com.daelly.common.sample.collection;

import com.google.common.collect.ImmutableSet;
import org.apache.commons.collections4.SetUtils;

import java.util.Set;

public class CollectionTest {


    public static void main(String[] args) {
        Set<Integer> a = ImmutableSet.of(1, 2, 3);
        Set<Integer> b = ImmutableSet.of(2, 3, 4);
        System.out.println(SetUtils.difference(a, b));
        System.out.println(SetUtils.difference(b, a));
    }
}
