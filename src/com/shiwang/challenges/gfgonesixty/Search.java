package com.shiwang.challenges.gfgonesixty;

import java.util.ArrayList;
import java.util.Arrays;

public class Search {

    public static void main(String[] args) {
        int[] a = new int[]{1, 2, 4, 8, 9};
//        int[] b = new int[]{1, 2, 4, 6, 8, 10};

//        System.out.println(aggressiveCows(a, 3));
        int[] b = new int[]{1, 2, 3, 4, 5, 6};
        System.out.println(findPages(b, 5));
    }

    public static int findPages(int[] arr, int k) {
        // code here

        if( k > arr.length){
            return -1;
        }

        int low = 0;
        int high = arr.length;
        int maxpage = 0;
        while(low < high){

            int mid = (low + high - 1)/2;
            if (mid + k - 1 <= arr.length) {
                int leftsum = pagesum(0, mid, arr);
                int rightsum = pagesum(mid, arr.length, arr);
                if(leftsum < rightsum){
                    low = mid + 1;
//                maxpage = leftsum;
                } else {
                    maxpage = leftsum;
                    high = mid;
                }
            } else{
                high = mid;

            }

        }

        return maxpage;

    }

    static int pagesum(int start, int end, int[] arr){
        int s = 0;
        for(int i = start; i < end; i++ ){
            s += arr[i];
        }

        return s;
    }

    public static int minDays(int[] bloomDay, int k, int m) {
        int n = bloomDay.length;

        // Quick impossible case: not enough flowers at all
        if ((long) m * k > n) return -1;

        int minDay = Integer.MAX_VALUE;
        int maxDay = Integer.MIN_VALUE;

        for (int day : bloomDay) {
            minDay = Math.min(minDay, day);
            maxDay = Math.max(maxDay, day);
        }

        int low = minDay;
        int high = maxDay;
        int ans = -1;

        while (low <= high) {
            int mid = low + (high - low) / 2; // candidate day

            if (canMake(bloomDay, m, k, mid)) {
                ans = mid;           // mid works → try earlier
                high = mid - 1;
            } else {
                low = mid + 1;       // mid too early → need more days
            }
        }

        return ans;
    }

    private static boolean canMake(int[] bloomDay, int m, int k, int day) {
        int bouquets = 0;
        int consecutive = 0;

        for (int d : bloomDay) {
            if (d <= day) {
                consecutive++;
                if (consecutive == k) {
                    bouquets++;
                    consecutive = 0; // reset after forming a bouquet
                }
            } else {
                consecutive = 0; // break in consecutiveness
            }

            if (bouquets >= m) return true;
        }

        return false;
    }


    static int minDaysBloom(int[] arr, int k, int m) {
        // code here
        if(m * k > arr.length){
            return -1;
        }


        int min = findMinOrMax(arr, true);
        int max = findMinOrMax(arr, false);
        int ans = min;

        while(min <= max){

            int mid = (min + max)/2;

            var possible = check(mid, arr, k, m);

            if(possible){
                ans = mid;
                max = mid -1;
            } else{
                min = mid + 1;
            }
        }

        return ans;

    }

    static boolean check(int day, int[] arr, int bunch, int bouquet){
        int count = 0;
        int bou = 0;
        for(int i =0; i < arr.length; i++){

            if(arr[i] <= day){
                count++;
            } else{
                count = 0;
            }
            if(count == bunch){
                bou++;
                count = 0;
            }
            if(bou == bouquet){
                return true;
            }
        }

        return false;
    }

    // boolean bunchpossible(int[] arr, int start, int bunch){
    //     int b = bunch;
    //     while(b > 0){
    //         if(arr[start++] <= day){

    //         }
    //     }
    // }


    static int findMinOrMax(int[] arr, boolean findmin){

        int min = arr[0];

        for(int i = 1; i < arr.length; i++){

            if(findmin && arr[i] < min){
                min = arr[i];
            }
            if(!findmin){
                if(arr[i] > min){
                    min = arr[i];
                }
            }
        }
        return min;
    }

    public static int kokoEat(int[] arr, int k) {

        int max = 0;

        for(int a: arr){

            if(a > max){
                max = a;
            }
        }
        int low = 1;
        int ans = max;
        int high = max;

        while(low <= high){
            int mid = low + (high - low) / 2;
            int count = 0;

            for(int i = 0 ; i < arr.length; i++){

                if(arr[i] <= mid){
                    count++;
                } else{
                    count = count + arr[i]/mid;
                    if(arr[i] % mid != 0){
                        count++;
                    }
                }
            }
            if(count <= k){
                ans = mid;
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }

        return ans;
    }

    static int findeqorgreat(int[] arr, int max){
        int sec = -1;
        for(int a: arr){
            if(a <= max && a > sec){
                sec = a;
            }
        }
        return sec;
    }

    public static int peakElementBsearch(int[] arr) {
        // code here
        int low = 0;
        int high = arr.length;

        if(arr.length == 1){
            return 0;
        }
        if(arr[0] > arr[1]){

            return 0;
        }
        if(arr[high - 1] > arr[high - 2]){

            return high - 1;
        }

        while(low < high){

            int mid = (low + high - 1)/2;

            if(arr[mid] > arr[mid + 1]){
                if(arr[mid] > arr[mid - 1]){
                    return mid;
                } else{
                    high = mid;
                }
            }else{
                low = mid + 1;
            }
        }

        return 0;
    }


    public static int peakElement(int[] arr) {
        // code here


        if(arr.length == 1){
            return 0;
        } else{

            for(int i = 0; i < arr.length; i++){

                if (i == 0 && arr[i] > arr[i + 1]){
                    return 0;
                }
                else if(i == arr.length - 1 && arr[i] > arr[i - 1]){
                    return i;
                }
                else {
                    if(i > 0 && arr[i] > arr[i-1] && arr[i] > arr[i+1]){
                        return i;
                    }
                }
            }

        }

        return 0;

    }

    public static int findFloor(int[] arr, int x) {
        // code here
        int index = -1;

        int low = 0;
        int high = arr.length - 1;

        while(low < high){
            int mid = (low+high)/2;
            if(arr[mid] > x){
                high= mid;
            } else{
                index = mid;
                low = mid + 1;
            }
        }

        return index;
    }

    static ArrayList<Integer> find(int arr[], int x) {
        // code here

        int minlow = 0;
        int maxlow = 0;
        int minhigh = arr.length;
        int maxhigh = arr.length;
        int findex = -1;
        int lindex = -1;
        while(minlow < minhigh || maxlow < maxhigh){

            int minmid = (minlow + minhigh - 1)/2;

            int maxmid = (maxlow + maxhigh - 1)/2;

            if(arr[minmid] == x){
                findex = minmid;
                minhigh = minmid;
            } else if(arr[minmid] > x){
                minhigh = minmid;
            } else{
                minlow = minmid + 1;
            }

            if(arr[maxmid] == x){
                lindex = maxmid;
                maxlow = maxmid + 1;
            } else if(arr[maxmid] > x){
                maxhigh = maxmid;
            } else{
                maxlow = maxmid + 1;
            }


        }

        return new ArrayList<>(Arrays.asList(findex, lindex));
    }

    public static int aggressiveCows(int[] stalls, int k) {
        // code here

        Arrays.sort(stalls);
        int n = stalls.length;

        int maxDiff = 0;
        int max = stalls[n - 1] - stalls[0];

        for(int a = 1; a <= max; a++){

            int first = stalls[0];
            int count = 1;
            for(int b  = 1; b < n; b++){

                if(stalls[b] - first >= a) {
                    first = stalls[b];
                    count++;
                }

            }
            if(count >= k){
                maxDiff = a;
            }

        }

        return maxDiff;

    }

    static int findMin(int[] arr){
        // complete the function here
        int low  = 0;
        int high = arr.length - 1;
        int max = arr[arr.length - 1];
        int hIndex = arr.length - 1;
        while(low <= high){
            int mid = (low + high)/2;

            if(arr[mid] < max){
                high = mid - 1;
            } else {
                low = mid + 1;
                max = arr[mid];
                hIndex = mid;
            }
        }

        if(hIndex == arr.length - 1){
            return arr[hIndex];
        }
        low = hIndex + 1;
        high = arr.length - 1;
        int min = arr[low];

        while(low <= high){
            int mid = (low + high)/2;

            if(arr[mid] < min){
                high = mid - 1;
                min = arr[mid];
            } else {
                high = mid-1;
            }
            if(arr[mid] == min){
                break;
            }
        }

        return min;
    }

    public static int findMin1(int[] arr) {
        // complete the function here
        int low  = 0;
        int high = arr.length -1;

        while(low < high){

            if(arr[low] < arr[high]){
                return arr[0];
            }
            int mid = (low + high)/2;

            if(arr[mid] > arr[high]){
                low = mid + 1;
            } else {
                high = mid;
            }
        }

        return arr[low];
    }


    static int search(int[] arr, int key) {
        // code here
        int low = 0;
        int high = arr.length - 1;
        while(low <= high){

            int mid = (low + high)/2;
            if(arr[mid] == key){
                return mid;
            }
            if(arr[low] < arr[high]){
                if(arr[mid] == key){
                    return mid;
                }
                if(arr[mid] < key){
                    low = mid + 1;
                } else{
                    high = mid -1;
                }
            } else if (arr[mid] > arr[high] && arr[high] >= key){
                if(arr[high] == key){
                    return high;
                }
                low = mid + 1;
            } else if (arr[mid] > arr[high] && arr[mid] > key){
                high = mid - 1;
            } else if (arr[mid] > arr[high] && arr[mid] < key){
                low = mid + 1;
            }else {
                high = mid;
            }

        }

        return -1;

    }

    public static int kthElement1(int a[], int b[], int k) {
        // code here
        int i = 0;
        int j = 0;
        int count = 0;
        while(i < a.length && j < b.length){
            boolean iInc = false;
            if(a[i] < b[j]){
                count++;
                i++;
                iInc = true;
            } else{
                count++;
                j++;
            }

            if(count == k){
                if(iInc){
                    return a[i - 1];
                }
                return b[j - 1];
            }
        }

        while(i < a.length){
            count++;
            if(count == k) {

                return a[i];
            }
            i++;
        }

        while(j < b.length){
            count++;
            if(count == k) {

                return b[j];
            }
            j++;
        }

        return 0;
    }

    static int kthEGfg(int[] a, int[] b, int k){
        int n = a.length, m = b.length;

        // last element added to the merged
        // sorted array
        int last = 0;
        int i = 0, j = 0;
        for (int d = 0; d < k; ++d) {
            if (i < n) {

                // if a[i] > b[j] then increment j
                if (j < m && a[i] > b[j]) {
                    last = b[j];
                    j++;
                }

                // otherwise increment i
                else {
                    last = a[i];
                    i++;
                }
            }

            // if reached end of first array then
            // increment j
            else if (j < m) {
                last = b[j];
                j++;
            }
        }

        // return the last (kth) element
        return last;
    }

    public static double medianOf2(int a[], int b[]) {
        // Code Here
        int i = 0;
        int j = 0;
        int m = a.length + b.length;
        int n = m/2;
        int last = -1;
        int secondLast = -1;

        for(int d = 0; d <= n; d++){
            secondLast = last;
            if(i != a.length && j != b.length){
                last = (a[i] < b[j]) ? a[i++] : b[j++];
//                    last = a[i];
//                    i++;
//                } else {
//                    last = b[j];
//                    j++;
//                }
            } else if(i != a.length){
                last = a[i];
                i++;
            } else if(j != b.length){
                last = b[j];
                j++;
            }

        }

        if(m % 2 == 0){
            return (last + secondLast) /2.0;
        }
        else {
                return last;
        }
    }

    static double getMedian(int[] a, int[] b) {
        int n = a.length;
        int m = b.length;
        if(a.length > b.length){
            return getMedian(b, a);
        }

        // We can take [0...n] number of elements from a[]
        int low = 0, high = n;

        while (low <= high) {
            // Take mid1 elements from a
            int mid1 = (low + high) / 2;

            // Take mid2 elements from b
            int mid2 = (n + m + 1)/2 - mid1;

            // Find elements to the left and right of partition in a
            int l1 = (mid1 == 0 ? Integer.MIN_VALUE : a[mid1 - 1]);
            int r1 = (mid1 == n ? Integer.MAX_VALUE : a[mid1]);

            // Find elements to the left and right of partition in b
            int l2 = (mid2 == 0 ? Integer.MIN_VALUE : b[mid2 - 1]);
            int r2 = (mid2 == n ? Integer.MAX_VALUE : b[mid2]);

            // If it is a valid partition
            if (l2 <= r1 && l1 <= r2)
                return (Math.max(l1, l2) + Math.min(r1, r2)) / 2.0;

            // If we need to take fewer elements from a
            if (l1 > r2)
                high = mid1 - 1;

                // If we need to take more elements from a
            else
                low = mid1 + 1;
        }

        return 0;
    }

    public int kthElement(int a[], int b[], int k) {
        // code here
        if(a.length > b.length){
            return kthElement(b,a, k);
        }

        int low = Math.max(0, k - b.length);
        int high = Math.min(k,a.length);
        while(low <= high){

            int mid = (low + high)/2;
            int mid2 = k - mid;

            int max1 = (mid == 0) ? Integer.MIN_VALUE : a[mid - 1];
            int min1 = (mid == a.length) ? Integer.MAX_VALUE : a[mid];

            int max2 = (mid2 == 0) ? Integer.MIN_VALUE : b[mid2 - 1];
            int min2 = (mid2 == b.length) ? Integer.MAX_VALUE : b[mid2];

            if(max1 <= min2 && max2 <= min1) return Math.max(max1, max2);

            if(max1 > min2){
                high = mid - 1;
            } else{
                low = mid + 1;
            }
        }
        return 0;
    }


    static int kthElement2(int[] a, int[] b, int k) {
        int n = a.length, m = b.length;

        // if a[] has more elements, then call
        // kthElement with reversed parameters
        if (n > m)
            return kthElement2(b, a, k);

        // binary Search on the number of elements we
        // can include in the first set from a[]
        int lo = Math.max(0, k - m), hi = Math.min(k, n);

        while (lo <= hi) {
            int mid1 = (lo + hi) / 2;
            int mid2 = k - mid1;

            // find elements to the left and right of
            // partition in a[]
            int l1 = (mid1 == 0 ? Integer.MIN_VALUE :
                    a[mid1 - 1]);
            int r1 = (mid1 == n ? Integer.MAX_VALUE :
                    a[mid1]);

            // find elements to the left and right of
            // partition in a[]
            int l2 = (mid2 == 0 ? Integer.MIN_VALUE :
                    b[mid2 - 1]);
            int r2 = (mid2 == m ? Integer.MAX_VALUE :
                    b[mid2]);

            // if it is a valid partition
            if (l1 <= r2 && l2 <= r1) {
                // find and return the maximum of l1 and l2
                return Math.max(l1, l2);
            }

            // check if we need to take lesser elements
            // from a[]
            if (l1 > r2)
                hi = mid1 - 1;

                // check if we need to take more elements
                // from a[]
            else
                lo = mid1 + 1;
        }

        return 0;
    }









//    1, 3, 7, 9, 11, 13

//    1, 2, 4, 6, 8, 10

//     1, 1, 2, 3, 4, 6, 7, 8, 9, 10, 11, 13

}
