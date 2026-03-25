package com.shiwang.challenges.gfgonesixty;

import java.util.Arrays;
import java.util.Random;

public class FindMedian {

    public static void main(String[] args) {
        int[] arr = {12, 3, 6, 7, 4, 19, 17};
        System.out.println(findMedian(arr));
        int[] a1 = new int[]{5, 8, 9};
        int[] a2 = new int[]{ 4, 6, 7, 8};
        mergeArrays(a1, a2);
        System.out.print(Arrays.toString(a1));
        System.out.print(Arrays.toString(a2));
    }




        static void mergeArrays(int[] a, int[] b) {
            int n = a.length;
            int m = b.length;
            int gap = (n + m + 1) / 2;

            while (gap > 0) {
                int i = 0, j = gap;

                while (j < n + m) {


                    // If both pointers are in the first array a[]
                    if (j < n && a[i] > a[j]) {
                        int temp = a[i];
                        a[i] = a[j];
                        a[j] = temp;
                    }

                    // If first pointer is in a[] and
                    // the second pointer is in b[]
                    else if (i < n && j >= n && a[i] > b[j - n]) {
                        int temp = a[i];
                        a[i] = b[j - n];
                        b[j - n] = temp;
                    }

                    // Both pointers are in the second array b
                    else if (i >= n && b[i - n] > b[j - n]) {
                        int temp = b[i - n];
                        b[i - n] = b[j - n];
                        b[j - n] = temp;
                    }
                    i++;
                    j++;
                }

                // After operating for gap of 1 break the loop
                if (gap == 1) break;

                // Calculate the next gap
                gap = (gap + 1) / 2;
            }
        }

    public static double findMedian(int[] arr) {
        double ans;
        int[] a = {-1};
        int[] b = {-1};
        int n = arr.length;

        if (n % 2 == 1) {
            medianUtil(arr, 0, n - 1, n / 2, a, b);
            ans = b[0];
        } else {
            medianUtil(arr, 0, n - 1, n / 2, a, b);
            ans = (a[0] + b[0]) / 2.0;
        }
        return ans;
    }



    public static int partition(int[] arr, int l, int r) {
        int lst = arr[r], i = l, j = l;
        while (j < r) {
            if (arr[j] < lst) {
                swap(arr, i, j);
                i++;
            }
            j++;
        }
        swap(arr, i, r);
        return i;
    }

    public static int randomPartition(int[] arr, int l, int r) {
        Random rand = new Random();
        int n = r - l + 1;
        int pivot = rand.nextInt(n);
        swap(arr, l + pivot, r);
        return partition(arr, l, r);
    }

    public static void medianUtil(int[] arr, int l, int r, int k, int[] a, int[] b) {
        if (l <= r) {
            int partitionIndex = randomPartition(arr, l, r);
            // find the median of odd number element in arr[]
            if (partitionIndex == k) {
                b[0] = arr[partitionIndex];
                if (a[0] != -1) return;
            } else if (partitionIndex == k - 1) { // a & b as middle element of arr[]
                a[0] = arr[partitionIndex];
                if (b[0] != -1) return;
            }
            // index in first half of the arr[]
            if (partitionIndex >= k)
                medianUtil(arr, l, partitionIndex - 1, k, a, b);
                // find the index in second half of the arr[]
            else
                medianUtil(arr, partitionIndex + 1, r, k, a, b);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
