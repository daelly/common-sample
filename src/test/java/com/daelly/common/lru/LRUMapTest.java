package com.daelly.common.lru;

import org.apache.commons.collections4.map.LRUMap;
import org.junit.jupiter.api.Test;

public class LRUMapTest {

    @Test
    public void test1() {
        LRUMap<String, String> map = new LRUMap<>(3);
        map.put("1", "1");
        map.put("2", "2");
        map.put("3", "3");

        map.get("2");

        System.out.println("---------------------------------");
        map.forEach((k, v) ->
                System.out.println(k + "\t" + v)
        );

        map.put("4", "4");
        map.put("5", "5");

        System.out.println("---------------------------------");
        map.forEach((k, v) ->
                System.out.println(k + "\t" + v)
        );

        map.put("6", "6");

        System.out.println("---------------------------------");
        map.forEach((k, v) ->
                System.out.println(k + "\t" + v)
        );

    }
}
