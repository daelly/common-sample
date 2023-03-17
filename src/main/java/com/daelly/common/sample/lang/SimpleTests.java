package com.daelly.common.sample.lang;

public class SimpleTests {

    public static void main(String[] args) {
        try {
            System.out.println("trying");
            throw new RuntimeException("trying");
        } catch (Exception e) {
            if ("1".equals("1")) {
                throw new RuntimeException("exception");
            }
            System.out.println("exception");
        } finally {
            System.out.println("finally");
        }

        System.out.println("end out");
    }
}
