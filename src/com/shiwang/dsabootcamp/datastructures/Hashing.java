package com.shiwang.dsabootcamp.datastructures;

import java.util.*;

public class Hashing {

    public static void main1(String[] args) {
        int[] aa = {5, 1, -41, 23, -2, 64, 40, -9, -22, 55, 95};

        twoSum(aa, 2);
        int[] b = {11, 3, 7, 1, 7};
        Map<Integer,Integer> aset = new HashMap<>();
        Map<Integer,Integer> bset = new HashMap<>();

        Set<Integer> subs = new HashSet<>();

        for(int a: aa){
            subs.add(a);
        }
        int target = 12;
        for (Iterator<Integer> it = subs.iterator(); it.hasNext(); ) {
            Integer a = it.next();
            if(a == target){
                continue;
            }
            if(subs.contains(target - a)){
                return;
            }
        }

//        for(int i: a){
//            if(aset.get(i) == null){
//                aset.put(i, 1);
//            } else{
//                aset.put(i, aset.get(i) + 1);
//            }
//
//        }
        for(int i: b){
            if(bset.get(i) == null){
                bset.put(i, 1);
            } else{
                bset.put(i, bset.get(i) + 1);
            }
        }

        for(Map.Entry<Integer,Integer> e: bset.entrySet()){
            if(aset.get(e.getKey()) == null){
                System.out.println("false");
            }
            if(aset.get(e.getKey()) < bset.get(e.getKey())){
                System.out.println("false");
            }
        }

        System.out.println("true");

//        Map<Integer,Integer> subs = new HashMap<>();

//        for(int i: aa){
//            if(subs.get(i) == null){
//                subs.put(i, 1);
//            } else{
//                subs.put(i, subs.get(i) + 1);
//            }
//        }

    }

    public static void main(String[] args) {
        Hashing hs = new Hashing();
        String[] aa = {"act", "god", "cat", "dog", "tac"};
        System.out.println(hs.anagrams(aa));
    }

    public long subarrayXor(int arr[], int k) {
        // code here

        int curr = 0;
        int result = 0;
        int xor = 0;
        Map<Integer, Integer> map = new HashMap<>();
        map.put(0, 1);
        for(int a: arr){
            xor = a ^ xor;
//            if(xor == k){
//                result++;
//            }
            curr =  xor ^ k;
            if(map.containsKey(xor ^ k)){
                result += map.get(xor ^ k);
            }

            map.put(xor, map.getOrDefault(xor, 0) + 1);
        }

        return result;
    }

    public ArrayList<ArrayList<String>> anagrams(String[] arr) {
        // code here
        Map<String, Integer> words = new HashMap<>();
        ArrayList<ArrayList<String>> list = new ArrayList<>();
        int index = 0;
        for(String a : arr){
            String hash = getHash(a);
            if(!words.containsKey(hash)){
                words.put(hash, index++);
                list.add(new ArrayList<>());
            }
            list.get(words.get(hash)).add(a);
//            words.get(hash).add(a);
        }
        return list;
    }

    String getHash(String s){

        int[] count = new int[26];

        for(char c : s.toCharArray()){
            count[c - 'a']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < count.length; i++){
            if(count[i] > 0){
                sb.append(i);
                sb.append(count[i]);
            }
        }

        return sb.toString();
    }

    static boolean twoSum(int arr[], int target) {
        // code here

        Map<Integer,Integer> subs = new HashMap<>();

        for(int i: arr){
            if(subs.get(i) == null){
                subs.put(i, 1);
            } else{
                subs.put(i, subs.get(i) + 1);
            }
        }

        for(int a: arr){

            if( a == target){
                continue;
            }
            if(subs.containsKey(target - a) && target - a != a){
                return true;
            } else if(subs.containsKey(target - a)){
                if(target - a == a && subs.get(target - a) > 1){
                    return true;
                }
            }
        }

        return false;
    }

    public int cntSubarrays(int[] arr, int k) {
        // code here
        int count= 0;
        for(int i = 1; i <= arr.length; i++){

            for(int j = 0; j + i <= arr.length; j++){
                int sum = subsum(arr, j, i);
                if(sum == k){
                    count++;
                }
            }
        }

        return count;
    }

    static int cntSubarrays1(int[] arr, int k) {

        // HashMap to store prefix sums frequencies
        Map<Integer, Integer> prefixSums = new HashMap<>();
        int res = 0;
        int currSum = 0;

        for (int i = 0; i < arr.length; i++) {
            // Add current element to sum so far.
            currSum += arr[i];

            // If currSum is equal to desired sum
            // then a new subarray is found.
            if (currSum == k)
                res++;

            // Check if the difference exists in the prefixSums map.
            if (prefixSums.containsKey(currSum - k))
                res += prefixSums.get(currSum - k);

            // Add currSum to the set of prefix sums.
            prefixSums.put(currSum, prefixSums.getOrDefault(currSum, 0) + 1);
        }

        return res;
    }

    int subsum(int[] arr, int start, int end){
        int sum= 0, a = 0;
        int i = start;
        while(a < end){
            sum += arr[i++];
            a++;
        }
        return sum;
    }

    public List<List<Integer>> findTriplets(int[] arr) {
        // Your code here
        Map<Integer, List<int[]>> map = new HashMap<>();

        List<List<Integer>> result = new ArrayList<>();

        for(int i =0; i < arr.length; i++){

            for(int j = i + 1; j < arr.length; j++){

                int rem = arr[i] + arr[j];
                if(!map.containsKey(rem)){
                    map.put(rem, List.of(new int[]{i,j}));
                } else{
                    map.get(rem).add(new int[]{i,j});
                }

            }

        }

        for(int i =0; i < arr.length; i++){

            int rem = -arr[i];

            if(map.containsKey(rem)){

                List<int[]> pairs = map.get(rem);

                for(int[] p: pairs){

                    if(p[0] > i && p[1] > p[0]){
                        result.add(List.of(i, p[0], p[1]));
                    }
                }
            }
        }

        return result;

    }

    public List<List<Integer>> findTriplets3(int[] arr) {
        // Your code here
        Map<Integer, Integer> map = new HashMap<>();
        int index = 0;
        for(int i =0; i < arr.length; i++){
            map.put(arr[i], i);
        }
        List<List<Integer>> result = new ArrayList<>();

        for(int i =0; i < arr.length -2; i++){

            for(int j = i + 1; j < arr.length - 1; j++){

                int rem = arr[i] + arr[j];
                if(map.containsKey(0 - rem) && map.get(0 - rem) > j){
                    var curr = List.of(i, j, map.get(0 - rem));
                    Collections.sort(curr);
                    result.add(curr);
                }
            }

        }

        return result;


    }
}



