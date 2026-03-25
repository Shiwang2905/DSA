package com.shiwang.dsabootcamp.datastructures.stack;

import java.util.Stack;

public class MyQueue {


        // Initialize your data members
        Stack<Integer> stack = new Stack<>();
        Stack<Integer> queue = new Stack<>();


        void enqueue(int x) {
            // Implement enqueue operation
            while (!stack.empty())
                queue.push(stack.pop());

            stack.push(x);
            while(!queue.empty())
                stack.push(queue.pop());
        }

        void dequeue() {
            // Implement dequeue operation
            if(stack.empty()){
                return;
            }
            stack.pop();
        }

        int front() {
            // Implement front operation
            if(stack.empty()){
                return -1;
            }
            return stack.pop();
        }

        int size() {
            return stack.size();
        }
    int[] arr;
    int top1;
    int top2;
    int mid;

    MyQueue(int n) {
        arr = new int[n];
        mid = n % 2 == 0 ? n/2 - 1: n/2;

        top1 = 0;
        top2 = mid;
    }


}
