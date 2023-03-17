package com.daelly.common.io;

import org.junit.jupiter.api.Test;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.Arrays;

/**
 * 运行结果：
 * LITTLE_ENDIAN
 * [0, 97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102]
 * [0, 97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102]
 * [0, 97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102]
 * [0, 97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102]
 * [97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102, 0]
 * [0, 97, 0, 98, 0, 99, 0, 100, 0, 101, 0, 102]
 * [1, 2, 3, 4, 5, 6, 7, 8]
 * [8, 7, 6, 5, 4, 3, 2, 1]
 * [8, 7, 6, 5, 4, 3, 2, 1, 16, 15, 14, 13, 12, 11, 10, 9]
 *
 * 疑惑一：为什么不一样的结果不是整个颠倒的，而是两两内部颠倒？
 * 第一，一个字节（byte）是存储的最小单元，如果写入和读出的是byte类型，那么大小端的设置对结果将毫无影响。
 * 第二，ByteOrder影响的是：需要多个字节保存的数据它的高位字节~地位字节的对应的存储地址是 低地址~高地址（大端）还是 高地址~低地址（小端）；
 * 第三，通过第1和第2个对比知道，写字符串其实是逐个写字符，ByteOrder并不能影响每次独立的写入产生的顺序，改变ByteOrder不会让ByteBuffer从后往前写数据或读数据；
 *
 * 疑惑二：为什么调成和nativeOrder不一样的BIG_ENDIAN反而获得一样的结果？
 * 因为java 默认是大端写入、大端读出。nativeOrder的结果是什么对后续的测试没有影响。所以不管在哪里设置ByteBuffer为BIG_ENDIAN对结果都没有影响
 *
 * 疑惑三：为什么在写入之前设置不一样的LITTLE_ENDIAN结果不一致，而在写入后设置的LITTLE_ENDIAN没有影响？
 * 这里分两部分回答：
 * 第一，ByteBuffer.array()不是一个读操作，纯粹是一个返回实际保存的字节数组的操作，实际就是将已经写好的东西直接返回；所以写好了之后再设置ByteOrder对返回结果是没有影响的
 * 第二，ByteOrder是影响写操作的，所以在写之前设置不一样的ByteOrder，那每次写入的char（包含两个字节）高低位字节就会颠倒过来
 */
public class ByteOrderTests {

    @Test
    public void testByteOrder() {
        System.out.println(ByteOrder.nativeOrder());
    }

    @Test
    public void testByteOrder1() {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.asCharBuffer().put("abcdef");

        System.out.println(Arrays.toString(bb.array()));
    }

    @Test
    public void testByteOrder2() {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.putChar('a');
        bb.putChar('b');
        bb.putChar('c');
        bb.putChar('d');
        bb.putChar('e');
        bb.putChar('f');

        System.out.println(Arrays.toString(bb.array()));
    }

    @Test
    public void testByteOrder3() {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.order(ByteOrder.BIG_ENDIAN);
        bb.putChar('a');
        bb.putChar('b');
        bb.putChar('c');
        bb.putChar('d');
        bb.putChar('e');
        bb.putChar('f');

        System.out.println(Arrays.toString(bb.array()));
    }

    @Test
    public void testByteOrder4() {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.putChar('a');
        bb.putChar('b');
        bb.putChar('c');
        bb.putChar('d');
        bb.putChar('e');
        bb.putChar('f');
        bb.order(ByteOrder.BIG_ENDIAN);

        System.out.println(Arrays.toString(bb.array()));
    }

    @Test
    public void testByteOrder5() {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.putChar('a');
        bb.putChar('b');
        bb.putChar('c');
        bb.putChar('d');
        bb.putChar('e');
        bb.putChar('f');

        System.out.println(Arrays.toString(bb.array()));
    }

    @Test
    public void testByteOrder6() {
        ByteBuffer bb = ByteBuffer.wrap(new byte[12]);
        bb.putChar('a');
        bb.putChar('b');
        bb.putChar('c');
        bb.putChar('d');
        bb.putChar('e');
        bb.putChar('f');
        bb.order(ByteOrder.LITTLE_ENDIAN);

        System.out.println(Arrays.toString(bb.array()));
    }

    /**
     * 输出：[1, 2, 3, 4, 5, 6, 7, 8]
     * java 默认是大端存储：高位字节（1）存在低地址（数组头），低位字节（8）存在高地址（数组尾）
     */
    @Test
    public void testByteOrder7() {
        ByteBuffer bb = ByteBuffer.wrap(new byte[8]);
        bb.putLong(0x01_02_03_04_05_06_07_08L);

        System.out.println(Arrays.toString(bb.array()));
    }

    /**
     * 输出：[8, 7, 6, 5, 4, 3, 2, 1]
     * 小端：高位字节（1）存在高地址（数组尾），低位字节（8）存在低地址（数组头）
     */
    @Test
    public void testByteOrder8() {
        ByteBuffer bb = ByteBuffer.wrap(new byte[8]);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.putLong(0x01_02_03_04_05_06_07_08L);

        System.out.println(Arrays.toString(bb.array()));
    }

    /**
     * 输出：[8, 7, 6, 5, 4, 3, 2, 1, 16, 15, 14, 13, 12, 11, 10, 9]
     * ByteOrder不影响写ByteBuffer的顺序，但是对每个Long的存储顺序都有改变
     */
    @Test
    public void testByteOrder9() {
        ByteBuffer bb = ByteBuffer.wrap(new byte[16]);
        bb.order(ByteOrder.LITTLE_ENDIAN);
        bb.putLong(0x01_02_03_04_05_06_07_08L);
        bb.putLong(0x09_0a_0b_0c_0d_0e_0f_10L);

        System.out.println(Arrays.toString(bb.array()));
    }
}
