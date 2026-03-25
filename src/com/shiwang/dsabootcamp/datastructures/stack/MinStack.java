package com.shiwang.dsabootcamp.datastructures.stack;

import java.util.Stack;

class MinStack {


    int minEle;
    Stack<Integer> st;

    public MinStack() {
        st = new Stack<>();
        minEle = -1;
    }

    // Add an element to the top of Stack
    public void push(int x) {
        if (st.isEmpty()) {
            minEle = x;
            st.push(x);
        }
        // If new number is less than minEle
        else if (x < minEle) {
            st.push(2 * x - minEle);
            minEle = x;
        } else {
            st.push(x);
        }
    }

    // Remove the top element from the Stack
    public void pop() {
        if (st.isEmpty()) {
            return;
        }

        int top = st.pop();

        // Minimum will change, if the minimum element
        // of the stack is being removed.
        if (top < minEle) {
            minEle = 2 * minEle - top;
        }
    }

    // Returns top element of the Stack
    public int peek() {
        if (st.isEmpty()) {
            return -1;
        }

        int top = st.peek();

        // If minEle > top means minEle stores value of top.
        return (minEle > top) ? minEle : top;
    }

    // Check if the stack is empty
    boolean isEmpty() {
        return st.isEmpty();
    }

    // Finds minimum element of Stack
    public int getMin() {
        if (st.isEmpty()) {
            return -1;
        }

        // variable minEle stores the minimum element
        // in the stack.
        return minEle;
    }


    public static void main(String[] args) {
        MinStack minStack1 = new MinStack();
        minStack1.push(5);
        System.out.println(minStack1.isEmpty());
        minStack1.pop();
        System.out.println(minStack1.getMin());
        minStack1.push(16);
        minStack1.push(4);
        minStack1.push(2);
        minStack1.pop();
        minStack1.pop();
        System.out.println(minStack1.getMin());
        System.out.println(minStack1.isEmpty());
    }
}
