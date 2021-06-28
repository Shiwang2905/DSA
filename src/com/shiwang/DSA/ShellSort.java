package com.shiwang.DSA;

public class ShellSort {

    public static void main(String[] args) {

        int[] inputArray= {12,-30,4,-6,32,85,-10};

        shellSort(inputArray);

        for(int i=0; i<inputArray.length; i++){
            System.out.println(inputArray[i]);
        }
    }

    static void shellSort(int[] array) {

        int gap=array.length/2;
        while(gap>0) {
            for (int i = gap; i <= array.length - 1; i++) {
                int unSortedValue = array[i];
                int j;
                for (j = i; j > 0 && array[j - gap] > unSortedValue; j -= gap) {
                    array[j] = array[j - gap];
                }

                array[j] = unSortedValue;
            }
            gap /= 2;
        }
    }
}
