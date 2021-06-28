package com.shiwang.DSA;

public class InsertionSort {

    public static void main(String[] args) {

        int[] inputArray= {12,-30,4,-6,32,85,-10};

        insertionSort(inputArray);

        for(int i=0; i<inputArray.length; i++){
            System.out.println(inputArray[i]);
        }
    }

    static void insertionSort(int[] array) {

        for (int i = 1; i <= array.length - 1; i++) {
                int unSortedValue=array[i];
            int j;
            for (j = i; j > 0 && array[j-1]>unSortedValue; j--) {
                array[j]=array[j-1];
            }
            array[j]=unSortedValue;
        }

    }
}
