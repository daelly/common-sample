package com.daelly.common.lang;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

public class LangTests {

    @Test
    public void testArrayCopy() {
        String[] array1 = new String[10];
        array1[0] = "one";
        String[] array2 = {"two", "three", "four", "five", "six", "seven", "eight", "nine", "ten"};

        System.arraycopy(array2, 0, array1, 1, array2.length);

        Arrays.stream(array1).forEach(System.out::println);
    }
}
