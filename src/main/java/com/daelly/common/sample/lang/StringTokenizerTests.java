package com.daelly.common.sample.lang;

import java.util.StringTokenizer;

public class StringTokenizerTests {

    public static void main(String[] args) {
        String s = "The Java platform is the ideal platform for network computing";
        StringTokenizer tokenizer = new StringTokenizer(s);
        System.out.println(tokenizer.countTokens());
        while (tokenizer.hasMoreElements()) {
            System.out.println(tokenizer.nextToken());
        }
    }
}
