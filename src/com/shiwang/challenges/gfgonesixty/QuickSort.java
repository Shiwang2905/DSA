package com.shiwang.challenges.gfgonesixty;

import java.util.Arrays;

public class QuickSort {

    public static void main(String[] args) {
        int[] arr = {3, 5, 1, 4, 2, 6};
        QuickSort qs = new QuickSort();
        qs.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    void sort(int[] arr, int low, int high) {
        if (low < high) {
            int pi = partition(arr, low, high);
            sort(arr, low, pi - 1);
            sort(arr, pi + 1, high);
        }
    }

    static int partition(int[] arr, int low, int high) {

        int pivot = arr[high];
        int i = low;
        int j;
        for (j = low; j < high; j++) {
            if (arr[j] < pivot) {
//                i++;
                swap(arr, i, j);
                i++;
            }
        }
        swap(arr, i, j);
        return i;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
