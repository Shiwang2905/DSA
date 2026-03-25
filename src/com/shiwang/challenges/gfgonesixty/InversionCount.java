package com.shiwang.challenges.gfgonesixty;

public class InversionCount {

    public static void main(String[] args) {
        // Code Here
        int[] arr = {2, 4, 1, 3, 5};
        System.out.println(inversionCount(arr));
    }

    static int inversionCount(int[] arr) {
        // Code Here
        return sort(arr);
    }

    static int sort(int[] arr){
        int count = 0;
        if(arr.length > 1) {

            int end = arr.length;
            int mid = end / 2;
            int i = 0;
            int[] left = new int[mid];
            int[] right = new int[end - mid];

            while(i < mid){
                left[i] = arr[i++];
            }
            while(i < end){
                right[i - mid] = arr[i++];
            }

            count += sort(left);
            count += sort(right);
            count += merge(left, right, arr);
        }

        return count;

    }

    static int merge(int[] arr1, int[] arr2, int[] arr){
        int count = 0;
        int i = 0,j=0,k=0;

        while(i < arr1.length && j < arr2.length){
            if(arr1[i] > arr2[j]){
                arr[k++] = arr2[j++];
                count += arr1.length - i;
            }
            else{
                arr[k++] = arr1[i++];
            }
        }

        while(i < arr1.length){
            arr[k++] = arr1[i++];
        }
        while(j < arr2.length){
            arr[k++] = arr2[j++];
        }
        return count;

    }

}
