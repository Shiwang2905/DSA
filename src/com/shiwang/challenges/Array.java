package com.shiwang.challenges;

import java.util.*;

public class Array {

    public static int findSecondLargest(int[] inputArray) throws IllegalArgumentException {
        int min;
        int max;
        if (inputArray[0] < inputArray[inputArray.length - 1]) {
            min = inputArray[0];
            max = inputArray[inputArray.length - 1];
        } else {
            min = inputArray[inputArray.length - 1];
            max = inputArray[0];
        }

        if (inputArray.length > 2) {
            for (int i = 1; i < inputArray.length; i++) {
                int current = inputArray[i];
                if (current > min && current < max) {
                    min = inputArray[i];
                } else if (current > min && current > max) {
                    min = max;
                    max = current;
                }
            }
        } else if (inputArray.length == 2) {
            throw new IllegalArgumentException();
        }
        return min;
    }

    public static void main(String[] args) {

//        System.out.println(summaryRanges(new int[]{0,1,2,4,5,7}));
//        System.out.println(minimumSumSubarray(List.of(3, -2, 1, 4), 2, 3));
//        System.out.println(Arrays.toString(findMajority(new int[]{2, 4, 1, 7, 5, 0})));
//        System.out.println(findMajority1(new int[]{2, 1, 5, 5, 5, 5, 6, 6, 6, 6, 6}));
//        System.out.println(maxSubarraySum(new int[]{-79, -68, -18, -58, 25, 52, -68, -30, 6, 10}));
//        System.out.println(maxSubarraySum(new int[]{2,3,-8,7, -1, 2, 3}));
//        twoIndexSum();
//        System.out.println(maxPro());
//        System.out.println(areRotations("abcd", "acbd"));
//        System.out.println(startAndEnd(" 1231231231311133"));
//        System.out.println(addBinary("00001", "111110"));
//        System.out.println(divide(98, 2));

//        leftShift(3, 0);
//        rightShift(1024, 2);
//        System.out.println(findOccurrences("abcdbcdc", "bcdb"));
//        sort012(new int[]{0, 1, 1, 0, 1, 2, 1, 2, 0, 0, 0, 1});
//        System.out.println(hIndex(new int[]{5, 1, 1, 4, 1}));
//        System.out.println(inversionCount(new int[]{57, 38, 91, 10, 38, 28, 79, 41}));
//        System.out.println(Arrays.toString(insertionSort(new int[]{57, 38, 91, 10, 5, 28, 79, 41})));
        int[] a1 = new int[]{5, 8, 9};
        int[] a2 = new int[]{ 4, 6, 7, 8};
        mergeTwoSortedArray(a1, a2);
        System.out.print(Arrays.toString(a1));
        System.out.print(Arrays.toString(a2));
        var result = new ArrayList<Integer>();
        Collections.sort(result, Comparator.reverseOrder());
//        8, 9, 10, 11, 12, 13
    }


    static void merge2(int[] arr1, int[] arr2){
        int gap = (arr1.length + arr2.length + 1)/ 2;
        int i = 0;
        int j = gap + i;
        while(gap > 0){

        }

        if(i < arr1.length && j < arr2.length){
            if(arr1[i] > arr2[j]){
                int temp = arr1[i];
                arr1[i] = arr2[j];
                arr2[j] = temp;
            }
        }
    }

    static void mergeTwoSortedArray(int[] arr1, int[] arr2) {
        int n = arr1.length + arr2.length;
        int gap = (arr1.length + arr2.length + 1)/2;

        while (gap >0) {
            int i = 0;
            for (int j = gap; j  < n; j++) {


                if (j < arr1.length && arr1[i] > arr1[j]) {
                        int temp = arr1[i];
                        arr1[i] = arr1[j];
                        arr1[j] = temp;

                }
                else if( i < arr1.length && j >= arr1.length && arr1[i] > arr2[j - arr1.length]){
                            int temp = arr1[i];
                            arr1[i] = arr2[j - arr1.length];
                            arr2[j - arr1.length] = temp;
                }
                else if(i >= arr1.length && arr2[i - arr1.length] > arr2[j - arr1.length]){
                        int temp = arr2[i - arr1.length];
                        arr2[i - arr1.length] = arr2[j - arr1.length];
                        arr2[j - arr1.length] = temp;

                }
                i++;
            }
            if(gap == 1) break;
            gap = (gap + 1)/ 2;
        }
    }

    static int hcf(int a, int b) {
        if (b == 0) {
            return a;
        }
        int hcf = 1;
        for (int i = 2; i <= Math.max(a, b); i++) {
            if (a % i == 0 && b % i == 0) {
                hcf = i;
            }
        }
        return hcf;
    }


    static int[] insertionSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            int key = arr[i];
            if (key < arr[i - 1]) {
                int j = i - 1;
                while (j >= 0 && arr[j] > key) {
                    arr[j + 1] = arr[j];
                    j--;
                }
                arr[j + 1] = key;
            }
        }
        return arr;
    }


    static int inversionCount(int arr[]) {
        // Your Code Here

        int count = 0;
        // for(int i =0; i < arr.length -1; i++){

        //     for(int j =i + 1; j < arr.length; j++){
        //         // int j = i + 1;
        //         if(arr[i] > arr[j]){
        //             count++;
        //         }
        //     }
        // }

        for (int i = 0; i < arr.length - 1; i++) {
            int curr = arr[i];
            for (int j = i + 1; j < arr.length; j++) {
                // int j = i + 1;
                if (curr > arr[j]) {
                    count++;
                    System.out.println("Pair : {" + arr[i] + "," + arr[j] + "}");
                    int temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }

            }
        }
        return count;
    }

    public static int hIndex(int[] citations) {
        // code here
        Arrays.sort(citations);
        int hindex = 0;
        int n = citations.length;
        for (int i = 0; i < n; i++) {
            if (citations[i] == 0) {
                continue;
            }
            if (citations[i] >= hindex + 1 && n - i >= hindex + 1) {
                hindex += 1;
                i--;
            }
        }
        return hindex;
    }

    public static void sort012(int[] arr) {
        // code here

        int zero = 0;
        int one = 0;
//        int two = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                zero++;
                continue;
            }
            if (arr[i] == 1) {
                one++;
            }
//            if(arr[i] == 2){
//                two++;
//            }
        }
        int counter = 0;
        while (counter < arr.length) {

            if (zero > 0) {
                arr[counter] = 0;
                zero--;
            } else if (one > 0) {
                arr[counter] = 1;
                one--;
            } else {
                arr[counter] = 2;
            }
            counter++;
        }
        System.out.println(Arrays.toString(arr));

    }

    // Build longest prefix suffix (LPS) array
    private static int[] buildLPS(String pat) {
        int m = pat.length();
        int[] lps = new int[m];
        int len = 0;
        int i = 1;

        while (i < m) {
            if (pat.charAt(i) == pat.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1]; // fall back
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }

        return lps;
    }

    // Main KMP search function
    public static List<Integer> findOccurrences(String txt, String pat) {
        List<Integer> result = new ArrayList<>();
        int n = txt.length();
        int m = pat.length();

        if (m == 0 || n < m) return result;

        int[] lps = buildLPS(pat);
        int i = 0, j = 0;

        while (i < n) {
            if (txt.charAt(i) == pat.charAt(j)) {
                i++;
                j++;
                if (j == m) {
                    result.add(i - j);  // pattern found at index (i - j)
                    j = lps[j - 1];     // move pattern based on LPS
                }
            } else {
                if (j != 0) {
                    j = lps[j - 1];     // fallback in pattern
                } else {
                    i++;                // move to next character in text
                }
            }
        }

        return result;
    }

    static ArrayList<Integer> search(String pat, String txt) {
        // your code here
        ArrayList<Integer> result = new ArrayList<>();
        int j = 0;
        for (int i = 0; i < txt.length(); i++) {
            if (txt.charAt(i) == pat.charAt(j)) {
                if (j + 1 == pat.length()) {
                    result.add(i - pat.length() + 1);
                    j = -1;
                    i = i - pat.length() + 1;
                }
                j++;

            } else {
                i = i - j;
                j = 0;
            }

        }
        return result;
    }

    public static void leftShift(int n, int shifyBy) {
        int i = 0;
        while (i < 10) {
            n = n << shifyBy++;
            i++;
            System.out.println(n);
        }
    }

    public static void rightShift(int n, int shifyBy) {
        int i = 0;
        while (i < 10) {
            n = n >> shifyBy;
            i++;
            System.out.println(n);
        }
    }

    public static int divide(int dividend, int divisor) {

        if (dividend == divisor) {
            return 1;
        }
        if (divisor == 1) {
            return dividend;
        }
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        int positive = 1;
        if (dividend < 0 && divisor > 0) {
            positive = -1;
        }
        if (dividend > 0 && divisor < 0) {
            positive = -1;
        }

        int count = 0;
        long divid = Math.abs((long) dividend);
        long divs = Math.abs((long) divisor);
        while (divid >= divs) {
            int p = 0;
            while (divid >= divs << p) {
                p++;
            }
            p--;
            count += 1 << p;
            divid -= divs << p;
        }

        return count * positive;

    }

    public static String addBinary(String s1, String s2) {
        // code here
        if (s1.length() < s2.length()) {
            return addBinary(s2, s1);
        }
        int idx1;
        for (idx1 = 0; idx1 < s1.length(); idx1++) {
            if (s1.charAt(idx1) == '1') {
                break;
            }
        }
        int idx2;
        for (idx2 = 0; idx2 < s2.length(); idx2++) {
            if (s2.charAt(idx2) == '1') {
                break;
            }
        }
        char[] temp = new char[s1.length() + s2.length()];
        int tempn = temp.length;
        int carry = 0;
        int diff = Math.abs(s1.length() - s2.length());
        int n = s1.length() - 1;
        int lowestIdx = Math.min(idx1, idx2);
        while (n >= lowestIdx) {
            char first = '0';
            if (n >= idx1) {
                first = s1.charAt(n);
            }
            char second = '0';
            if (n - diff >= idx2) {
                second = s2.charAt(n - diff);
            }
            if (first == '0' && second == '0') {
                if (carry == 1) {
                    temp[tempn-- - 1] = '1';
                } else {
                    temp[tempn-- - 1] = '0';

                }
                carry = 0;
            } else if (first == '0' && second == '1'
                    || first == '1' && second == '0') {
                if (carry == 1) {
                    temp[tempn-- - 1] = '0';
                } else {
                    temp[tempn-- - 1] = '1';
//                    carry = 0;
                }

            } else {
                if (carry == 1) {
                    temp[tempn-- - 1] = '1';
                } else {
                    temp[tempn-- - 1] = '0';

                }
                carry = 1;
            }
            n--;
        }


        if (carry == 1) {
            temp[tempn-- - 1] = '1';
        }
        int i;
        for (i = tempn; i < temp.length; i++) {
            if (temp[i] == '1') {
                tempn = i;
                break;
            }
        }
        StringBuilder sb = new StringBuilder();
        while (tempn < temp.length) {
            sb.append(temp[tempn++]);
        }

        return new String(sb);
    }

    static int maxPro() {
        return -1 * 6;
    }

    static int maxSubarraySum(int[] arr) {
        // Your code here
        int maxSum = arr[0];

        for (int window = 0; window < arr.length; window++) {
            int sum = 0;
            for (int i = window; i < arr.length; i++) {

                sum += arr[i];
                maxSum = Math.max(maxSum, sum);
            }
        }
        return maxSum;
    }

    public static List<String> summaryRanges(int[] nums) {
        StringBuilder sb = new StringBuilder();
        boolean newSTr = true;
        List<String> result = new ArrayList<>();

        for (int i = 0; i < nums.length - 1; i++) {

            if (nums[i + 1] - nums[i] == 1) {
                if (newSTr) {
                    sb.append(nums[i]).append("->");
                    newSTr = false;
                }
            } else {
                sb.append(nums[i]);
                result.add(new String(sb));
                sb = new StringBuilder();
                newSTr = true;
            }
        }
        sb.append(nums[nums.length - 1]);
        result.add(new String(sb));
        return result;
    }

    public static int strStr(String haystack, String needle) {

        int j = 0;
        boolean found = true;
        for (int i = 0; i < haystack.length() && j < needle.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(j)) {
                found = true;
                j++;
            } else {
                found = false;
                j = 0;
            }
        }
        if (found) {
            return haystack.indexOf(needle.charAt(0));
        }
        return -1;
    }

    public static int[] findXSum(int[] nums, int k, int x) {

        Map<Integer, Integer> elementsCount = new HashMap<>();
        int[] result = new int[nums.length - k + 1];
        int resultIndex = 0;
        for (int i = 0; i < nums.length - k + 1; i++) {
            int j = i;
            while (j < k + i) {
                elementsCount.put(nums[j], elementsCount.getOrDefault(nums[j], 0) + 1);
                j++;
            }
//            result[resultIndex++] = getSum(elementsCount, x);
        }

        return result;
    }

    public static int[] findXSum1(int[] nums, int k, int x) {
        int n = nums.length;

        int[] ans = new int[n - k + 1];
        for (int i = 0; i < n - k + 1; i++) {
            Map<Integer, Integer> map = new HashMap<>();
            for (int j = i; j < i + k; j++) {
                map.put(nums[j], map.getOrDefault(nums[j], 0) + 1);
            }

            List<Pair> list = new ArrayList<>();
            for (int key : map.keySet()) {
                list.add(new Pair(map.get(key), key));
            }
            list.sort((Pair a, Pair b) -> {
                if (a.first == b.first) {
                    return b.second - a.second;
                }
                return b.first - a.first;
            });

            int sum = 0;
            int uniq = 0;
            for (Pair l : list) {
                if (uniq >= x) {
                    break;
                }

                sum += l.first * l.second;
                uniq++;
            }
            ans[i] = sum;
        }
        return ans;
    }

    static class Pair {
        int first;
        int second;

        public Pair(int first, int second) {
            this.first = first;
            this.second = second;
        }
    }

    public static int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int ans = Integer.MAX_VALUE;

        for (int windowSize = l; windowSize <= r; ++windowSize) {
            int sum = 0;
            for (int i = 0; i < windowSize; ++i)
                sum += nums.get(i);
            if (sum > 0)
                ans = Math.min(ans, sum);
            for (int i = windowSize; i < nums.size(); ++i) {
                sum -= nums.get(i - windowSize);
                sum += nums.get(i);
                if (sum > 0)
                    ans = Math.min(ans, sum);
            }
        }

        return ans == Integer.MAX_VALUE ? -1 : ans;
    }

    static int[] nextPermutation(int[] arr) {
        // code here
        int n = arr.length;
        int i = n - 1;
        boolean found = false;
        int b = -1;
        int c = i;

        while (i >= b) {
            int j = i - 1;
            while (j >= 0) {
                if (arr[i] > arr[j]) {
                    if (j > b) {
                        b = j;
                        c = i;
                        found = true;
                        break;
                    }
                }
                j--;
            }
            if (!found) {
                c -= 1;
            }
            i--;
        }

        if (found) {
            int tempA = arr[b];
            arr[b] = arr[c];
            arr[c] = tempA;
            int[] tempArr = new int[n - b - 1];
            for (int a = 0; a < tempArr.length; a++) {
                tempArr[a] = arr[a + b + 1];
            }
            Arrays.sort(tempArr);
            for (int a = b + 1; a < arr.length; a++) {
                arr[a] = tempArr[a - b - 1];
            }
        } else {
            for (int k = 0; k < n / 2; k++) {
                int temp = arr[k];
                arr[k] = arr[n - k - 1];
                arr[n - k - 1] = temp;
            }
        }
        return arr;
    }

    public static List<Integer> findMajority(int[] nums) {
        // Your code goes here.
        Map<Integer, Integer> majority2 = new HashMap<>();
        Set<Integer> result = new HashSet<>();
        int candidate = nums[0];
        int count = 1;
        int prevCount = 1;
        for (int i = 1; i < nums.length; i++) {
            // if(majority2.getOrElse(nums[i], 0) >= n/3){
            //     result.add(nums[i]);
            // }
            // majority2.put(nums[i], majority2.getOrElse(nums[i], 0) + 1);
//             if(count == 0){
//                 candidate = nums[i];
//             }
            if (candidate == nums[i]) {
                count++;
            } else {
                count--;
                candidate = nums[i];
                if (count == 0) {
                    count = 1;
                }
            }
            if (count >= nums.length / 3 && count > prevCount) {
                prevCount = count;
                result.add(candidate);
            }

        }
        List<Integer> output = new ArrayList<>(result.size());
        if (result.size() > 0) {
            for (Integer val : result) {
                output.add(val);
            }
            Collections.sort(output);
        }
        return output;

    }

    public static List<Integer> findMajority1(int[] nums) {
        int n = nums.length;
        int num1 = 0, num2 = 0, c1 = 0, c2 = 0;

        // Finding the two most frequent numbers using the Boyer-Moore algorithm
        for (int x : nums) {
            if (x == num1) {
                c1++;
            } else if (x == num2) {
                c2++;
            } else if (c1 == 0) {
                num1 = x;
                c1++;
            } else if (c2 == 0) {
                num2 = x;
                c2++;
            } else {
                c1--;
                c2--;
            }
        }

        // Reset the counts to check if num1 and num2 are indeed the majority
        c1 = 0;
        c2 = 0;
        for (int x : nums) {
            if (x == num1) {
                c1++;
            } else if (x == num2) {
                c2++;
            }
        }

        // Prepare the result list
        List<Integer> result = new ArrayList<>();
        if (c1 > n / 3) result.add(num1);
        if (c2 > n / 3) result.add(num2);

        // Sort the result and convert it to an array
        Collections.sort(result);

        return result;
    }

    static void twoIndexSum() {
        int window = 2;
        var arr = new int[]{-79, -68, -18, -58, 25, 52, -68, -30, 6, 10};
        int maxSum = 0;
        for (int i = 0; i < arr.length; i++) {
            int j = i;
            int sum = 0;
            while (j < window + i) {
                sum += arr[j];
                j++;
            }
            if (sum > maxSum) {

                maxSum = sum;
            }
        }
    }

    public static boolean areRotations(String s1, String s2) {
        // Your code here
        int j = 1;
        boolean yes = true;
        for (int i = 0; i < s1.length() && j < s1.length() + 1; i++) {
            int k = j;
            if (j >= s1.length()) {
                k = j - s1.length();
            }
            if (s1.charAt(i) != s2.charAt(k)) {
                i--;
                yes = false;
            } else {
                yes = true;
            }
            j++;
        }
        return yes;
//        char[] temp = new char[s1.length()];
//        for(int i =0; i < s1.length(); i++){
//            temp[i] = s1.charAt(i);
//        }
//
//        int k = 0;
//        while(k < s1.length() - 1){
//            if(equalStr(rotate(temp),s2)){
//                return true;
//            }
//            k++;
//        }
//        return false;
    }

    public static boolean equalStr(char[] temp, String s2) {

        for (int i = 0; i < temp.length; i++) {
            if (temp[i] != s2.charAt(i)) {
                return false;
            }
        }
        return true;
    }

    public static char[] rotate(char[] temp) {

        for (int i = temp.length - 1; i > 0; i--) {
            char curr = temp[i];
            temp[i] = temp[i - 1];
            temp[i - 1] = curr;
        }

        return temp;
    }

    static int startAndEnd(String s) {
        int start = -1;
        int end = -1;
        boolean positive = true;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if ((int) temp >= 49 && temp <= 57) {
                if (start == -1) {
                    start = i;
                }
                if (i > end) {
                    end = i;
                }
            } else {
                if (start > -1) {
                    break;
                }
                if (temp == '-') {
                    positive = false;
                }
                if (temp == '+') {
                    positive = true;
                }


            }
        }
        System.out.println("start: " + start + " end: " + end);
        int sum = 0;
        if (start == -1) {
            return 0;
        }
        int count = 0;
        for (int i = end; i >= start; i--) {
            char temp = s.charAt(i);
            int someVal = (int) ((temp - '0') * Math.pow(10, count));
            if (positive) {

                if (sum + someVal >= Integer.MAX_VALUE - 1) {
                    return Integer.MAX_VALUE;
                }
                sum += someVal;
            } else {
                sum -= someVal;
                if (sum > 0) {
                    return Integer.MIN_VALUE;
                }

            }

            count++;
        }

        return sum;
    }


}
