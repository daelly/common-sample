package com.daelly.common.algorithm.encode;

import org.apache.commons.lang3.RandomUtils;

import java.nio.charset.StandardCharsets;
import java.util.Base64;

public class SearchableEncode {

    public static void main(String[] args) {
        String s = "asufhsjhaskldfhaiokdfhsdfgasgsdfg";

        StringBuilder sb = new StringBuilder(s.length() *4);
        for (int i = 0; i <= s.length() - 4; i++) {
            String subStr = s.substring(i, i + 4);
            sb.append(Base64.getEncoder().encodeToString(subStr.getBytes(StandardCharsets.UTF_8)));
        }

        String encoded1 = sb.toString();

        System.out.println(encoded1);

        for (int i = 0; i < 10; i++) {
            int startIndex = RandomUtils.nextInt(0, s.length() - 3);
            String subStr = s.substring(startIndex, startIndex + 4);
            String encodedSubStr = Base64.getEncoder().encodeToString(subStr.getBytes(StandardCharsets.UTF_8));

            System.out.println(encoded1.contains(encodedSubStr));
        }
    }
}
