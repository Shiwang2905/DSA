package com.shiwang.DSA;

public class MergeSortTwo {

    public static void main(String[] args) {

        int[] inputArray= {12,-30,4,786,2,-45,-6,32,145};

        mergeSort(inputArray,0,inputArray.length);

        for(int i=0; i<inputArray.length; i++){
            System.out.println(inputArray[i]);
        }
    }

    private static void mergeSort(int[] array, int start, int end){

        if(end-start<2){
            return;
        }

        int mid=(start+end)/2;

        mergeSort(array,start,mid);
        mergeSort(array,mid,end);
        merge(array,start,mid,end);

    }

    private static void merge(int[] array, int start, int mid, int end) {

        if(array[mid-1]<=array[mid]){
            return;
        }

        int i=start;
        int j=mid;
        int k=0;

        int[] tempArray= new int[end-start];

        while(i< mid && j<end){
            tempArray[k++]= array[i]<=array[j]?array[i++]:array[j++];
        }

        System.arraycopy(array,i,array,start+k,mid-i);
        System.arraycopy(tempArray,0,array,start,k);

    }

}
