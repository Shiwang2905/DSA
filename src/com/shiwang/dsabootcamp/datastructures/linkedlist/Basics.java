package com.shiwang.dsabootcamp.datastructures.linkedlist;

import java.util.Objects;

public class Basics {

    public static void main(String[] args) {

        // single linked list
//        Node first = new Node(10);
//
//        first.next = new Node(20);
//
//        first.next.next = new Node(30);
//
//        Node current = first;
//
//        while (current != null) {
//            System.out.println(current.getValue());
//            current = current.next();
//        }

        // Doubly linked list

        DNode n1 = new DNode(10);

        n1.next = new DNode(20);
        n1.next.prev = n1;

        n1.next.next = new DNode(30);
        n1.next.next.prev = n1.next;

        n1.next.next.next = new DNode(40);
        n1.next.next.next.prev = n1.next.next;

        // traverse forward
        DNode temp = n1;

        while (temp != null) {
            System.out.print(temp.value + " , ");
            temp = temp.next();
        }
        System.out.println();

        // traverse backward
        temp = n1.next.next.next;

        while(temp != null){
            System.out.print(temp.value + " , ");
            temp = temp.prev();
        }
        System.out.println();

        // insert element at beginning

        DNode beg = new DNode(0);
        beg.next = n1;
        n1.prev = beg;

        temp = beg;
        while (temp != null) {
            System.out.print(temp.value + " , ");
            temp = temp.next();
        }
        System.out.println();

        temp = n1;
        // insert at the end
        while(temp.has()){
            temp = temp.next();
        }

        temp.next = new DNode(50);
        temp.next.prev = temp;

        temp = temp.next;
        while (temp.hasPrev()) {
            System.out.print(temp.value + " , ");
            temp = temp.prev();
        }

    }





    static class Node {

        private final int value;
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

    static class DNode {
        private final int value;
        public DNode next;
        public DNode prev;

        public DNode(int value) {
            this.value = value;
            this.next = null;
            this.prev = null;
        }

        public int getValue() {
            return this.value;
        }

        public DNode next() {
            return this.next;
        }

        public DNode prev() {
            return this.prev;
        }

        public boolean has(){
            return !Objects.isNull(next);
        }

        public boolean hasPrev(){
            return !Objects.isNull(prev);
        }

    }
}
