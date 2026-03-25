package com.shiwang.challenges.gfgonesixty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class MergeSort {

    public static void main(String[] args) {

        int[] arr = {3, 5, 1, 4, 2, 6};
//        System.out.println(Arrays.toString(mergeSort(arr)));
        System.out.println(Arrays.toString(quicksort(arr, 0, arr.length - 1)));

    }

    static int[] quicksort(int[] arr, int low, int high) {
        if (low < high) {
            int pivotIndex = partition(arr, low, high);
            quicksort(arr, low, pivotIndex - 1);
            quicksort(arr, pivotIndex + 1, high);
        }
        return arr;
    }

    static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (arr[j] < pivot) {
                i++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i + 1];
        arr[i + 1] = arr[high];
        arr[high] = temp;
        return i + 1;
    }

    static int[] mergeSort(int[] arr) {

        if (arr.length == 1) {
            return arr;
        }
        int n = arr.length;
        int m = n / 2;
        int[] left = new int[m];
        int[] right = new int[n - m];

        for (int i = 0; i < m; i++) {
            left[i] = arr[i];
        }
        left = mergeSort(left);
        for (int i = m; i < n; i++) {
            right[i - m] = arr[i];
        }
        right = mergeSort(right);
        return merge(left, right);

    }

    static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;

        // Merge the two arrays
        while (i < left.length && j < right.length) {
            if (left[i] <= right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }

        // Copy remaining elements from left array
        while (i < left.length) {
            result[k++] = left[i++];
        }

        // Copy remaining elements from right array
        while (j < right.length) {
            result[k++] = right[j++];
        }

        return result;
    }

//    public static int[] merge(int[] arr1, int[] arr2) {
//
//        int[] result = new int[arr1.length + arr2.length];
//
//        int i = 0;
//        while (i < arr1.length) {
//            result[i] = arr1[i];
//            i++;
//        }
//
//        int j = 0;
//        while (j < arr2.length) {
//            result[i] = arr2[j];
//            j++;
//            i++;
//        }
//
//        return result;
//    }
//
//    static int[] sort(int[] arr1, int[] arr2) {
//        if (arr1.length < arr2.length) {
//            return sort(arr2, arr1);
//        }
//        for (int i = 0; i < arr1.length; i++) {
//            for (int j = 0; j < arr2.length; j++) {
//                if (arr1[i] > arr2[j]) {
//                    int temp = arr1[i];
//                    arr1[i] = arr2[j];
//                    arr2[j] = temp;
//                }
//            }
//        }
//        return merge(arr1, arr2);
//    }

    public static ArrayList<Integer> findUnion(int a[], int b[]) {
        // code here
        ArrayList<Integer> result = new ArrayList<>();
        int i = 0, j = 0;
        Integer lastAdded = null;
        while(i < a.length && j < b.length){
            if(a[i] == b[j]){
                if(lastAdded == null || a[i] != lastAdded){
                    result.add(b[j]);
                    lastAdded=b[j];
                }
                j++;
                i++;
            }
            else if(a[i] < b[j]) {
                if(lastAdded == null || a[i] != lastAdded) {
                    result.add(a[i]);
                    lastAdded= a[i];
                }
                i++;
            }
            else{
                if(lastAdded == null || b[j] != lastAdded){
                    result.add(b[j]);
                    lastAdded=b[j];
                }
                j++;
            }
        }

        while(i < a.length && a[i] != lastAdded){
            result.add(a[i]);
            lastAdded= a[i++];
        }

        while(j < b.length && b[j] != lastAdded){
            result.add(b[j]);
            lastAdded=b[j++];
        }

        return result;
    }
}
