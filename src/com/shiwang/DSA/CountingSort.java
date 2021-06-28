package com.shiwang.DSA;

import java.util.Arrays;

public class CountingSort {

    public static void main(String[] args) {


        int[] inputArray = {20, 12, 4, 8, 2, 15, 6,2, 10};
        //int[] inputArray = {-30, 12, 4, 786, 2, -45, -6, 32, 145, 12, 45, 26, 48, 19, 3, 4868, 1535, 1001, 45, -186};
        countingSort(inputArray);

        for (int i : inputArray) {
            System.out.println(i);
        }
    }

    private static void countingSort(int[] array) {
        int maxValue = 0;
        for (int i : array) {
            if (i > maxValue) {
                maxValue = i;
            }
        }
        int countingArray[] = new int[maxValue];

        for (int i = 0; i < array.length; i++) {
            countingArray[array[i] - 1]++;
        }

        int arrayIndex = 0;
        for (int i = 0; i < countingArray.length && arrayIndex < array.length; i++) {
                if (countingArray[i]> 0) {
                    while (countingArray[i]-- >= 1) {
                        array[arrayIndex++] = i + 1;
                }
            }
        }

    }


    }
