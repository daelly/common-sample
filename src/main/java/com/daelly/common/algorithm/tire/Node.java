package com.daelly.common.algorithm.tire;

public class Node {

    public final char ch;

    public String str = null;

    public int count = 0;

    public Node[] children = new Node[Character.MAX_VALUE];

    public Node(char ch) {
        this.ch = ch;
    }
}
