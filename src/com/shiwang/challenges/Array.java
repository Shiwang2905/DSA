package com.shiwang.challenges;

public class Array {

    public static int findSecondLargest(int[] inputArray) throws IllegalArgumentException{
        int min;
        int max;
        if(inputArray[0]<inputArray[inputArray.length-1])
        {
            min=inputArray[0];
            max=inputArray[inputArray.length-1];
        }
        else {
            min=inputArray[inputArray.length-1];
            max=inputArray[0];
        }

        if(inputArray.length>2) {
            for (int i = 1; i < inputArray.length; i++) {
                int current = inputArray[i];
                if (current > min && current < max) {
                    min = inputArray[i];
                } else if (current > min && current > max) {
                    min = max;
                    max = current;
                }
            }
        }
        else if(inputArray.length==2){
            throw new IllegalArgumentException();
        }
        return min;
    }
    public static void main(String[] args) {

        System.out.println(findSecondLargest(new int[]{1,4,17,23,15,7,8}));
    }
}
