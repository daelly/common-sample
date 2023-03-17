package com.daelly.common.sample.guava.bloomfilter;

import com.google.common.hash.BloomFilter;
import com.google.common.hash.Funnels;

public class BloomFilterTest {


    public static void main(String[] args) {
        BloomFilter<Integer> filter = BloomFilter.create(Funnels.integerFunnel(), 500, 0.01);
        filter.put(1);
        filter.put(2);
        filter.put(3);
        filter.put(4);
        filter.put(5);

        System.out.println(filter.mightContain(3));
        System.out.println(filter.mightContain(5));
        System.out.println(filter.mightContain(7));
    }
}
