package com.shiwang.challenges.gfgonesixty;

import java.util.Arrays;
import java.util.Random;

public class QuickSortRandomPivot {
    Random rand = new Random();
    public static void main(String[] args) {
        int[] arr = {12, 3, 6, 7, 4, 19, 17};
        QuickSortRandomPivot randomQs  = new QuickSortRandomPivot();
        randomQs.sort(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }

    void sort(int[] arr, int low, int high){
        if(low < high){
            int randomPiv = rand.nextInt(high - low + 1);
            swap(arr, low + randomPiv, high);
            int pIndex = partition(arr, low, high);
            sort(arr, low, pIndex - 1);
            sort(arr, pIndex + 1, high);
        }
    }

    int partition(int[] arr, int low, int high){
        int pivot = arr[high];
        int i = low, j = low;
        while(j < high){
            if (arr[j] < pivot) {
                swap(arr, i, j);
                i++;
            }
            j++;
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
