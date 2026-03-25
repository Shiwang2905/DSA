package com.shiwang.dsabootcamp.datastructures.linkedlist;

public class Node {

    public int value;
    public Node next;

    public Node(int value) {
        this.value = value;
        this.next = null;
    }

    public int getValue() {
        return this.value;
    }

    public Node next() {
        return this.next;
    }
}
