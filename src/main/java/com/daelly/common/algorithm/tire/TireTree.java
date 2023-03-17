package com.daelly.common.algorithm.tire;

import java.util.ArrayList;
import java.util.List;

public class TireTree {

    private Node root = new Node((char) 0);

    public void add(String value) {
        Node n = root;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (n.children[c] == null) {
                n.children[c] = new Node(c);
            }
            n.children[c].count++;
            n = n.children[c];
        }
        n.str = value;
    }

    public boolean remove(String value) {
        Node n = root;
        List<Node> nodes = new ArrayList<> (value.length());
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (n.children[c] == null) {
                return false;
            }

            nodes.add(n.children[c]);
            n = n.children[c];
        }

        if (n.str == null) {
            return false;
        }
        for(Node node : nodes) {
            node.count--;
        }

        n.str = null;
        return true;
    }

    public boolean contains(String value) {
        Node n = root;
        for (int i = 0; i < value.length(); i++) {
            char c = value.charAt(i);
            if (n.children[c] == null) {
                return false;
            }

            n = n.children[c];
        }

        return n.str != null;
    }
}
