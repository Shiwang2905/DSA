package com.shiwang.DSA;

public class QuickSort {

    public static void main(String[] args) {

//        int[] inputArray= {-30,12,4,1,-6,28,54};
//        int[] inputArray= {-30,12,4,786,2,-45,-6,32,145};
        int[] inputArray = {-30, 12, 4, 786, 2, -45, -6, 32, 145, 12, 45, 26, 48, 19, 3, 4868, 1535, 1001, 45, -186};
        quickSort(inputArray, 0, inputArray.length);

        for (int i: inputArray) {
            System.out.println(i);
        }
    }

    private static void quickSort(int[] array, int start, int end) {

        if (end - start < 2) {
            return;
        }
        int i = start;
        int j = end - 1;
        int pivot=array[i];
        while (j > i) {
            if (array[j] < pivot) {
                array[i++] = array[j];
                while (i < j) {
                    if (array[i] > pivot) {
                        array[j] = array[i];
                        break;
                    }
                    i++;
                }
            }
            j--;
        }
        array[i] = pivot;
        quickSort(array, 0, i);
        quickSort(array, i + 1, end);

    }
}
