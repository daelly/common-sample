package com.daelly.common.algorithm.tire;

import org.junit.jupiter.api.Test;

public class TireTreeTest {

    @Test
    public void testTireTree() {
        TireTree t = new TireTree();
        String[] words = {"我爱我的祖国", "我爱北京天安门", "总有刁民想害朕"};
        for (String word : words) {
            t.add(word);
        }

        System.out.println(t.contains("总有刁民想害朕"));
        System.out.println(t.contains("我去"));
        System.out.println(t.contains("我爱"));
    }
}
