package com.shiwang.dsabootcamp.datastructures;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class StringQuestions {

    public int romanToInt(String s) {

        int sum = 0;
        char[] romanChars = s.toCharArray();
        for (int i = 0; i < romanChars.length; i++) {
            if (i + 1 < romanChars.length) {
                sum += subtractable(romanChars[i], romanChars[i + 1]);
                if (sum == 0) {
                    sum += getInt(romanChars[i]);
                }
                i++;
            } else {
                sum += getInt(romanChars[i]);
            }
        }
        return sum;
    }

    int getInt(char integerChar) {
        return switch (integerChar) {
            case 'I' -> 1;
            case 'V' -> 5;
            case 'X' -> 10;
            case 'L' -> 50;
            case 'C' -> 100;
            case 'D' -> 500;
            default -> 1000;
        };
    }

    int subtractable(char first, char second) {
        if (first == 'I' && (second == 'V' || second == 'X')) {
            return getInt(second) - getInt(first);
        } else if (first == 'X' && (second == 'L' || second == 'C')) {
            return getInt(second) - getInt(first);
        } else if (first == 'C' && (second == 'D' || second == 'M')) {
            return getInt(second) - getInt(first);
        } else {
            return 0;
        }

    }


    public static void main(String[] args) {
        StringQuestions stringQuestions = new StringQuestions();
        var arra = new String[]{"","b"};
        System.out.println(stringQuestions.containsNearbyDuplicate(new int[]{1,2,3,1,2,3}, 2));
    }

    public boolean containsNearbyDuplicate(int[] nums, int k) {

        // Map<Integer, Integer> uniques = new HashMap<>();
        // for(int i =0; i < nums.length; i++){
        //     if(uniques.containsKey(nums[i]) && Math.abs(uniques.get(nums[i])- i) <= k){
        //         return true;
        //     } else{
        //         uniques.put(nums[i], i);
        //     }
        // }
        // return false;

        HashSet<Integer> set = new HashSet<>();

        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the current element already exists in the set, return true (duplicate found)
            if (set.contains(nums[i])) return true;

            // Add the current element to the set
            set.add(nums[i]);

            // Maintain the sliding window size of at most 'k'
            // If the set size exceeds 'k', remove the element that is out of range
            if (set.size() > k) {
                set.remove(nums[i - k]); // Remove the element at distance 'k' behind the current index
            }
        }

        // If no duplicate is found within the given range, return false
        return false;
    }



}
