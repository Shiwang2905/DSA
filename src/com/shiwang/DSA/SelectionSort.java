package com.shiwang.DSA;

public class SelectionSort {

    public static void main(String[] args) {

        int[] inputArray= {-30,12,4,786,2,-45,-6,32,145};

        selectionSort(inputArray);

        for(int i=0; i<inputArray.length; i++){
            System.out.println(inputArray[i]);
        }

    }


    static void selectionSort(int[] array){
        int end=array.length-1;
        int max=array[0];
        int indexOfMax=0;
        for(int i=1; i<=end; i++){

            if(array[i]>max){
                max=array[i];
                indexOfMax=i;
            }
            if(i==end){
                array[indexOfMax]=array[i];
                array[end]=max;
                indexOfMax=0;
                i=0;
                max=array[0];
                end--;
            }
        }
    }
}

