package com.daelly.common.guava;

import com.google.common.collect.Iterators;
import org.junit.jupiter.api.Test;

public class CollectionsTests {

    @Test
    public void testIterators() {
        Iterable<Integer> iterable = () -> Iterators.forArray(1, 2, 3, 4, 5, 6, 7, 8);
        iterable.forEach(System.out::println);
    }
}
