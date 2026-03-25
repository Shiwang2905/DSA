package com.shiwang.dsabootcamp.datastructures.matrix;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Easy {
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

    public static void main(String[] args) {


        int[][] matrix = {{1,   2,   3,   4},
                           {5,    6,   7,   8},
                        {9,   10,  11,  12},
                      {13,  14,  15,  16}};

        int[][] mat = {
                {  3,  33,  72, 156, 175, 234, 313 },
                { 32,  96, 196, 199, 290, 348, 439 },
                { 23, 101, 155, 223, 261, 328, 417 },
                { 14,  88, 145, 193, 275, 311, 396 },
                { 13,  84, 115, 194, 253, 314, 327 },
                { 50,  83,  86, 141, 199, 254, 304 },
                { 32,  82, 168, 258, 285, 286, 321 }
        };

        int[][] smat = {
                {3, 30, 38},
                {44 ,52, 54},
                {57 ,60, 69}
        };
        System.out.println(matSearch(smat, 38));

//        System.out.println(searchRowMatrix(mat, 86));

//        printSpiral(matrix);

    }

    static void printSpiral(int[][] arr){
        int m = arr.length, n = arr[0].length;
        int r = 0;
        int c = 0;
        int count = 0;
        while( count <= m * n - 1){

            while(r == 0 && c < n){
                System.out.println(arr[r][c++]);
                count++;
            }

            while( c == n && r++ < m - 1){
                System.out.println(arr[r][c - 1]);
                count++;
            }

            if(r == c){
                c = c - 2;
                r = r - 1;
                while(c >= 0){
                    System.out.println(arr[r][c--]);
                    count++;
                }
            }
            while(c + 1 == 0 && r == m - 1){
                System.out.println();
            }

        }

    }

    static boolean searchRowMatrix(int[][] mat, int x) {
        // code here

        int r = mat.length;

        for(int i = 0; i < r; i++){
            int low = 0;
            int high = mat[i].length;
            while(low < high){

                int mid = (low + high - 1)/ 2;
                if(mat[i][mid] > x){
                    high = mid;
                } else if(mat[i][mid] == x) {
                    return true;
                } {
                    low = mid + 1;
                }

            }

        }

        return false;


    }

    static boolean matSearch(int[][] mat, int x) {
        // your code here

        int r = mat.length;
        int c = mat[0].length;

        int rlow = 0;
        int rhigh = r;

        while(rlow < rhigh){

            int rmid = (rlow + rhigh - 1)/2;
            int localmid;
            if(x <= mat[rmid][c - 1] && x >= mat[rmid][0] ){
                rhigh = rmid;
                localmid = rhigh;
            } else {
                rlow = rmid + 1;
                localmid = rmid;
            }

            int clow = 0;
            int chigh = c;

            while( clow < chigh){

                int cmid = (clow + chigh - 1)/2;

                if(mat[localmid][cmid] > x){
                    chigh = cmid;
                } else if(mat[localmid][cmid] == x){
                    return true;
                } else{
                    clow = cmid + 1;
                }
            }
        }

        return false;

    }

}
