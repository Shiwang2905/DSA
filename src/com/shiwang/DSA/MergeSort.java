package com.shiwang.DSA;

import javax.imageio.ImageReader;

public class MergeSort {

    public static void main(String[] args) {

        int[] inputArray= {-30,12,4,786,2,-45,-6,32,145};

        mergeSort(inputArray);

        for(int i=0; i<inputArray.length; i++){
            System.out.println(inputArray[i]);
        }
    }

    private static void mergeSort(int[] array){

        if(array.length<2){
            return;
        }
        int end=array.length;
        int mid=end/2;

        int[] left= new int[mid];
        int[] right= new int[end-mid];

        for(int i=0; i<mid; i++){
            left[i]=array[i];
        }
        for(int j=mid; j<end; j++){
            right[j-mid]=array[j];
        }

        mergeSort(left);
        mergeSort(right);
        merge(left,right,array);
    }

    private static void merge(int[] left, int[] right, int[] array) {

        int i=0,j=0,k=0;

        while(i< left.length && j<right.length){
            if(left[i]>=right[j]){
                array[k++]=right[j++];
            }else{
                array[k++]=left[i++];
            }
        }

        while(i<left.length){
            array[k++]=left[i++];
        }
        while(j<right.length){
            array[k++]=right[j++];
        }
    }

}
