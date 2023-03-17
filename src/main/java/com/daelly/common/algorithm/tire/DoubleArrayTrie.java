package com.daelly.common.algorithm.tire;

import java.util.List;

public class DoubleArrayTrie {

    private final static int BUF_SIZE = Character.MAX_VALUE;
    private final static int UNIT_SIZE = 8;

    private static class Node {
        int code;
        int depth;
        int left;
        int right;
    }

    private int check[];
    private int base[];

    private boolean used[];
    private int size;
    private int allocSize;
    private List<String> key;
    private int keySize;
    private int length[];
    private int value[];
    private int progress;
    private int nextCheckPos;
    int error_;

    private int resize(int newSize) {
        int[] base2 = new int[newSize];
        int[] check2 = new int[newSize];
        boolean used2[] = new boolean[newSize];
        if (allocSize > 0) {
            System.arraycopy(base, 0, base2, 0, allocSize);
            System.arraycopy(check, 0, check2, 0, allocSize);
            System.arraycopy(used, 0, used2, 0, allocSize);
        }

        base = base2;
        check = check2;
        used = used2;

        return allocSize = newSize;
    }

    private int fetch(Node parent, List<Node> siblings) {
        if (error_ < 0) {
            return 0;
        }

        int prev = 0;

        for (int i = parent.left; i < parent.right; i++) {
            if ((length != null ? length[i] : key.get(i).length()) < parent.depth) {
                continue;
            }

            String tmp = key.get(i);

            int cur = 0;
            if ((length != null ? length[i] : tmp.length()) != parent.depth) {
                cur = tmp.charAt(parent.depth) + 1;
            }

            if (prev > cur) {
                error_ = -3;
                return 0;
            }

            if (cur != prev || siblings.size() == 0) {
                Node tmp_node = new Node();
                tmp_node.depth = parent.depth + 1;
                tmp_node.code = cur;
                tmp_node.left = i;
                if (siblings.size() != 0) {
                    siblings.get(siblings.size() - 1).right = i;
                }
                siblings.add(tmp_node);
            }

            prev = cur;
        }

        if (siblings.size() != 0) {
            siblings.get(siblings.size() - 1).right = parent.right;
        }

        return siblings.size();
    }
}
