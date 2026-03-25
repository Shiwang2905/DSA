package com.shiwang.dsabootcamp.datastructures.linkedlist;

public class Operation {

    public static void main(String[] args) {

        Node head = new Node(1);
        Node n2 = new Node(2);
        head.next = n2;
        Node n3 = new Node(3);
        n2.next = n3;
        Node n4 = new Node(4);
        n3.next = n4;
//        Node n5 = new Node(5);
//        n4.next = n5;
//        Node n6 = new Node(6);
//        n5.next = n6;
//        Node n7 = new Node(7);
//        n6.next = n7;
//        n7.next = head;
//        n7.next = new Node(8);

//        Node result = deleteEveryKth(n3, 2);
//        Node result = middleNode(head);
        rotate(head, 6);
//        System.out.println(result);
//        System.out.println(result.getValue());
//        while (result != null) {
//            System.out.println(result.getValue());
//            result = result.next;
//        }
    }

    public static Node rotate(Node head, int k) {
        // code here
        int length = 0;
        Node temp = head;
        while(temp != null){
            temp = temp.next;
            length++;
        }

        k = k % length;

        int i = 1;
        Node curr = head;

        while(i < k){
            curr = curr.next;
            i++;
        }

        Node result = curr.next;
        temp = curr.next;
        curr.next = null;

        while(temp.next != null){
            temp = temp.next;
        }

        temp.next = head;


        return result;


    }

    public static void removeLoop(Node head) {
        // code here
        // Set<Node> present = new HashSet<>();
//        Node dummy = new Node(-1);
//        dummy.next = head;
        Node slow = head;
        Node fast = head;
        // present.add(curr);
        while(slow != null && fast != null && fast.next != null){

            slow = slow.next;
            fast = fast.next.next;
            if(slow == head){
                slow.next = null;
            } else if(fast == head) {
                fast.next.next = null;
            }


        }

    }

    public static boolean detectLoop(Node head) {
        // code here
        // Map<Node,Integer> nodepos = new HashMap<>();
        int count = 1;
        Node dummy = new Node(-1);
        dummy.next = head;
        Node curr = head;
        while(curr != null && curr.next != null){
            count++;
            Node next = curr.next;
            if(next.value == dummy.next.value){
                return true;
            }
            curr = curr.next;
        }

        return false;


    }

    public static boolean detectLoop1(Node head) {
        // code here
        // Map<Node,Integer> nodepos = new HashMap<>();
        int count = 1;
        Node dummy = new Node(0);
        dummy.next = head;
        Node curr = head;
        Node fast = head;
        while(curr != null && curr.next != null && fast != null && fast.next.next != null){
            count++;
            Node next = curr.next;
            Node fnext = fast.next.next;
            if(next.value == fnext.value){
                return true;
            }
            curr = curr.next;
            fast = fast.next.next;
        }

        return false;


    }

    static Node deleteKth(Node head, int k) {
        // Your code here
        if (k == 1) {
            return head.next;
        }
        int i = 1;
        Node temp = head;
        Node last = null;
        while (i++ < k && temp != null) {
            last = temp;
            temp = temp.next;
        }

        last.next = temp.next;
        temp.next = null;

        return head;
    }

    static Node deleteEveryKth(Node head, int k) {

        if (k == 1) {
            return null;
        }
        int i = 1;
        Node temp = head;
        Node last = null;
        while (temp != null) {
            last = temp;
            temp = temp.next;
            i++;
            if (i % k == 0) {
                last.next = temp.next;
            }
            if (temp.next == null) {
                return head;
            }

        }

        return head;

    }

    static Node middleNode(Node head) {

        Node slow = head;
        Node fast = head;

        while (fast != null && fast.next != null) {

            slow = slow.next;

            fast = fast.next.next;

        }

        return slow;
    }


    public static Node pairwiseSwap1(Node head) {
        // code here

        Node curr = head;

        while (curr != null && curr.next != null) {

            Node next = curr.next;
            curr.next = next.next;
            next.next = curr;
            head = next;
            curr = next.next.next;
        }

        return head;
    }

    public static Node pairwiseSwap2(Node head) {
        // code here

//        Node dummy = new Node(0);
//        dummy.next = head;

        Node curr = head;
        Node prev = curr;

        while(curr != null && curr.next != null){

            Node second = curr.next;
            Node third = second.next;

            curr.next = third;
            second.next = curr;
            prev.next = second;

            prev = second;
            curr = third.next;

        }

        return head;
    }

    static Node pairWiseSwap(Node node)
    {

        // If linked list is empty or there is only one node in list
        if (node == null || node.next == null) {
            return node;
        }

        // Initialize previous and current pointers
        Node prev = node;
        Node curr = node.next;

        node = curr; // Change head before proceeding

        // Traverse the list
        while (true) {
            Node next = curr.next;
            curr.next = prev; // Change next of current as previous node

            // If next NULL or next is the last node
            if (next == null || next.next == null) {
                prev.next = next;
                break;
            }

            // Change next of previous to next next
            prev.next = next.next;

            // Update previous and curr
            prev = next;
            curr = prev.next;
        }
        return node;
    }

    static Node pairwiseSwapGpt(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node dummy = new Node(0);
        dummy.next = head;

        Node prev = dummy;
        Node curr = head;

        while (curr != null && curr.next != null) {

            Node first = curr;
            Node second = curr.next;

            // swapping
            prev.next = second;
            first.next = second.next;
            second.next = first;

            // move pointers
            prev = first;
            curr = first.next;
        }

        return dummy.next;
    }

}
