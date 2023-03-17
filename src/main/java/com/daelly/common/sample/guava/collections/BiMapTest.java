package com.daelly.common.sample.guava.collections;

import com.google.common.collect.BiMap;
import com.google.common.collect.HashBiMap;

public class BiMapTest {

    public static void main(String[] args) {
        BiMap<String, Integer> biMap = HashBiMap.create();
        biMap.put("1", 1);
        biMap.put("2", 2);
        biMap.put("3", 3);
        System.out.println(biMap.inverse().get(2));
    }
}
