package com.shiwang.dsabootcamp.datastructures.stack;

import java.util.Stack;

import static com.shiwang.dsabootcamp.datastructures.stack.QueueUsingStack.isOpenBracket;

public class QueueUsingStack {


    // Initialize your data members
    Stack<Integer> stack = new Stack<>();
//        Stack<Integer> queue = new Stack<>();


    void enqueue(int x) {
        // Implement enqueue operation
        stack.push(x);
    }

    // 3, 2, 1
    void dequeue() {
        // Implement dequeue operation
        if (stack.empty()) {
            return;
        }

        int x = stack.pop();

        if (stack.empty()) {
            return;
        }

        dequeue();

        stack.push(x);
    }

    int front() {
        // Implement front operation
        if (stack.empty()) {
            return -1;
        }

        int value = stack.pop();

        if (stack.empty()) {
            return value;
        }

        int data = front();

        stack.push(value);

        return data;

    }

    int size() {
        return stack.size();
    }

    public static void main(String[] args) {
        QueueUsingStack result = new QueueUsingStack();
//        result.enqueue(5);
//        result.enqueue(3);
//        result.enqueue(4);
//        System.out.println(result.front());
//        result.dequeue();
//        int size = result.size();
//        System.out.println(size);
//        int front = result.front();
//        System.out.println(front);

//        Stack<Integer> stack1 = new Stack<>();
//        stack1.push(1);
//        stack1.push(2);
//        stack1.push(3);
//
//        addXtoFirst(stack1, 4);

        preToInfix("*-A/BC-/AKL");


    }


    static void addXtoFirst(Stack<Integer> stack, int x) {

        if (stack.empty()) {
            stack.push(x);
            return;
        }

        int val = stack.pop();

        if (stack.empty()) {
            stack.push(x);
            stack.push(val);
            return;
        }

        addXtoFirst(stack, x);

        stack.push(val);
    }

    static String preToInfix(String pre_exp) {
        // code here

        Stack<String> str = new Stack<>();

        char[] arr = pre_exp.toCharArray();
        for (int i = arr.length - 1; i >= 0; i--) {
            char c = arr[i];
            if (c == '*' || c == '+' || c == '-' || c == '/' || c == '%' || c == '^') {
                str.push('(' + str.pop() + c + str.pop() + ')');
            } else {
                str.push(String.valueOf(c));
            }
        }

        return str.pop();
    }

    public boolean isBalanced(String s) {
        // code here
        Stack<Character> stack = new Stack<>();
        for(int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if(!isOpenBracket(c)){
                if(stack.isEmpty()){
                    return false;
                }
                if((c == ')' && stack.peek() == '(')
                            || (c == '}' && stack.peek() == '{')
                            || (c == ']' && stack.peek() == '[')){
                        stack.pop();
                }else{
                    stack.push(c);
                }
            } else {
                stack.push(c);
            }
        }

        if(stack.size() > 0){
            return false;
        }

        return true;
    }

    static boolean isOpenBracket(char c){
        if(c == '{' || c == '(' || c == '['){
            return true;
        }
        return false;
    }

}
