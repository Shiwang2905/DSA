package com.shiwang.challenges.gfgonesixty;

public class PracticeSort {
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 29, 8, 3};
        PracticeSort ps = new PracticeSort();
//        ps.quickSort(arr);
        ps.sort(arr, 0, arr.length -1);
        for(int num : arr)
            System.out.print(num + " ");
    }

    void insertionSort(int[] arr){

        for(int i = 1; i < arr.length; i++){
            int j = i - 1;
            int key = arr[i];
            while(j >= 0 && key < arr[j]){
                arr[j + 1] = arr[j];
                j -= 1;
            }
            arr[j + 1] = key;
        }
    }
    void shellSort(int[] arr){
        int n = arr.length;

        for (int gap = n / 2; gap > 0; gap /= 2) {
            for (int i = gap; i < n; i++) {
                int key = arr[i];
                int j = i;
                while (j >= gap && arr[j - gap] > key) {
                    arr[j] = arr[j - gap];
                    j -= gap;
                }
                arr[j] = key;
            }
        }
    }

//    public void mergeArrays(int[] a, int[] b) {
//        // code here
//        int maxGap = Math.min(a.length, b.length);
//        for(int gap = maxGap/2; gap >= 1; gap /= 2){
//
//
//
//            for(int i = gap; i < n; i++){
//                int key = a[i];
//                int j = i;
//                while(j >= 0 && arr[j - gap] > key){
//                    arr[j] = arr[j - gap];
//                }
//                arr[j - gap] = key;
//            }
//        }
//
//    }

    public void quickSort(int[] arr) {
        sort(arr, 0, arr.length - 1);
    }

    private void sort(int[] arr, int low, int high){
        if(low < high){
            int pivotIndex = partition(arr, low, high);
            sort(arr, low, pivotIndex );
            sort(arr, pivotIndex + 1, high);
        }
    }

    public int luomotoPartition(int[] arr, int low, int high) {
        int i = low;
        int pivot = arr[high];
        for(int j = low; j < high; j++){
            if(arr[j] < pivot){
                int temp = arr[i];
                arr[i++] = arr[j];
                arr[j] = temp;
            }
        }
        int temp = arr[i];
        arr[i] = pivot;
        arr[high] = temp;
        return i;
    }

    public int hoarePartition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low;
        int j = high;
        while(i < j) {
            while (i <= high)  {
                if(arr[i] >= pivot) break;
                i++;
            }

            while (j >= 0) {
                if(arr[j] <= pivot) break;
                j--;
            }

            if (i < j) {
                int temp = arr[i];
                arr[i++] = arr[j];
                arr[j--] = temp;
            }
        }
        return j;
    }


    int partition(int[] arr, int low, int high) {
        int pivot = arr[low];
        int i = low -1, j = high + 1;
        while (true) {

            // find next element larger than pivot
            // from the left
            do {
                i++;
            } while (arr[i] < pivot);

            // find next element smaller than pivot
            // from the right
            do {
                j--;
            } while (arr[j] > pivot);

            // if left and right crosses each other
            // no swapping required
            if (i >= j) return j;

            // swap larger and smaller elements
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;

        }
    }
}
