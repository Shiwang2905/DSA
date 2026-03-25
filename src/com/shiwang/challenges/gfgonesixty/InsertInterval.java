package com.shiwang.challenges.gfgonesixty;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

public class InsertInterval {

    static public List<int[]> insertInterval1(int[][] intervals, int[] newInterval) {
        // code here
        Arrays.sort(intervals, (a,b) -> Integer.compare(a[0], b[0]));

        ArrayList<int[]> res = new ArrayList<>();
        int i = 0;
        int n = intervals.length;

        // Add all intervals that come before the new interval
        while (i < n && intervals[i][1] < newInterval[0]) {
            res.add(intervals[i]);
            i++;
        }

        // Merge all overlapping intervals with the new interval
        while (i < n && intervals[i][0] <= newInterval[1]) {
            newInterval[0] = Math.min(newInterval[0], intervals[i][0]);
            newInterval[1] = Math.max(newInterval[1], intervals[i][1]);
            i++;
        }
        res.add(newInterval);

        // Add all the remaining intervals
        while (i < n) {
            res.add(intervals[i]);
            i++;
        }

        // Return the result as a List<int[]>
        return res;
    }

    public static void main(String[] args) {
        int[][] input = {{13,14}, {13,19}, {6, 17}, {9,10}, {5,17},{9,15}, {7, 12}, {12,13}, {13,15}};
//        int[][] input = {{1,2}, {1,3}, {2, 3},{3,4}};
        var result = minRemoval(input);
//        for (int[] interval : result) {
            System.out.println(result);
//        }
    }

    public static int minRemoval(int intervals[][]) {
        // code here
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));

        // int[] last = intervals[0];
        int count = 0;
        List<int[]> merged = new ArrayList<>();
        merged.add(intervals[0]);
        for(int i = 1; i < intervals.length; i++){
            int[] current = intervals[i];
            int[] last = merged.getLast();
            if(current[0] < last[1]){
                count++;
                last[1] = Math.min(current[1], last[1]);
            }
            else {
                merged.add(current);
            }
        }
        return count;
    }
}
