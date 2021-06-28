package com.shiwang.DSA;

public class BubbleSort {

    static void bubbleSort(int[] inArray) {

        //Using only 1 Loop
        int end = inArray.length - 1;
        int i=0;
        while(i<end)
        {
            if (inArray[i] > inArray[i + 1])
            {
                int temp = inArray[i];
                inArray[i] = inArray[i + 1];
                inArray[i + 1] = temp;
            }
            i++;
            if(i==end)
            {
                end--;
                i=0;
            }
        }

        //Using two Loops
        /*for(int lastIndex=inArray.length-1; lastIndex>0; lastIndex--){
            for(int j=0; j<lastIndex; j++){
                if(inArray[j]>inArray[j+1]){
                    int tempValue=inArray[j];
                    inArray[j]=inArray[j+1];
                    inArray[j+1]=tempValue;
                }
            }
        }*/

    }

    public static void main(String[] args) {

        int[] inputArray= {-30,12,4,786,2,-45,-6,32,145};

        bubbleSort(inputArray);

        for(int i=0; i<inputArray.length; i++){
            System.out.println(inputArray[i]);
        }


    }
}
