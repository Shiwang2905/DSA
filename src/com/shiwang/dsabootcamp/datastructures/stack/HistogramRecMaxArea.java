package com.shiwang.dsabootcamp.datastructures.stack;

import java.util.ArrayList;
import java.util.Stack;

public class HistogramRecMaxArea {

//    Naive solution
//    public static void main(String[] args) {
//        // code here
//        int[] arr = {3};
//        int maxArea = arr[0];
//
//        for(int i = 0; i < arr.length; i++){
//            int area = arr[i];
//
//            for(int j = i - 1; j >= 0; j--){
//                if(arr[j] < arr[i]){
//                    break;
//                }
//                area += arr[i];
//            }
//
//            for(int j = i + 1; j < arr.length; j++){
//                if(arr[j] < arr[i]){
//                    break;
//                }
//                area += arr[i];
//            }
//
//            // area -= curr;
//
//            if(area > maxArea){
//                maxArea = area;
//            }
//
//        }
//
//        System.out.println(maxArea);
//    }

    //    optimised solution using two stacks
    public static void main(String[] args) {
        // code here
        int[] arr = {3, 5, 1, 7, 5, 9};
        int maxArea = arr[0];

        for (int i = 0; i < arr.length; i++) {
            int area = arr[i];

            int index = pse(arr, i, arr[i]);
            if(index != -1) {
                int k = i;
                while(k-- > index){
                    area += arr[i];
                }
            }

            index = nge(arr, i, arr[i]);
            if(index != -1) {
                int k = index;
                while(k-- > i)
                    area += arr[i];

            }


            if (area > maxArea) {
                maxArea = area;
            }

        }

        System.out.println(maxArea);
    }

    static int pse(int[] arr, int start, int ele) {

        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < start; i++) {
            stack.push(i);
        }
        int value = -1;
        while (!stack.empty() && arr[stack.peek()] >= ele) {
            value = stack.pop();
        }
        return value;
    }

    static int nge(int[] arr, int start, int ele) {

        Stack<Integer> stack = new Stack<>();
        for (int i = arr.length - 1; i > start; i--) {
            stack.push(i);
        }
        int value = -1;
        while (!stack.empty() && arr[stack.peek()] >= ele) {
            value = stack.pop();
        }
        return value;
    }
}
