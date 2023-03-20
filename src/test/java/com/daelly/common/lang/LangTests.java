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

    /**
     * 输出
     * 龘
     * 知乎-发现更大的世界，😂
     * 30693 20046 45 21457 29616 26356 22823 30340 19990 30028 65292 128514
     * code unit size:13
     * code point size:12
     */
    @Test
    public void testChar1() {
        char ch = '龘';
        System.out.println(ch);

//        for (int i = 0; i <= Integer.MAX_VALUE; i++) {
//            char c = (char) i;
//            System.out.print(c);
//            System.out.println("=" + i);
//        }

        //对non-MBP的字符，使用两个char来保存
        final String content = "知乎-发现更大的世界，\uD83D\uDE02";
        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            System.out.print(c);
        }

        System.out.println();

        for (int i = 0; i < content.length(); i++) {
            char c = content.charAt(i);
            System.out.print(c + " ");

        }

        System.out.println();

        for (int j = 0; j < content.codePointCount(0, content.length()); j++) {
            int value = content.codePointAt(j);
            System.out.print(value + " ");
        }

        System.out.println();


        //char 数组的大小是13个
        System.out.println("code unit size:" + content.length());
        //表示的字符只有12个
        System.out.println("code point size:" + content.codePointCount(0, content.length()));
    }


    @Test
    public void testChar2() {
        String content = "\uD83D\uDE00\uD83D\uDE01\uD83D\uDE02\uD842\uDCB8\uD841\uDF96";
        System.out.println(content);
        for (int j = 0; j < 5; j++) {
            //需要每次读取两个才能得到正确的Unicode编码
            int value = content.codePointAt(j * 2);
            System.out.print(value + " ");
        }
    }
}
