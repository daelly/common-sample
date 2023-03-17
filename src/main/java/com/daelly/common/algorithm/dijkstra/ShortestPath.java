package com.daelly.common.algorithm.dijkstra;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

public class ShortestPath {

    public static void main(String[] args) {
        System.out.println(ByteOrder.nativeOrder());

        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));


//        bb.rewind();
        bb = ByteBuffer.wrap(new byte[12]);
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));

//        bb.rewind();
        bb = ByteBuffer.wrap(new byte[12]);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.asCharBuffer().put("abcdef");
        System.out.println(Arrays.toString(bb.array()));
    }
}
