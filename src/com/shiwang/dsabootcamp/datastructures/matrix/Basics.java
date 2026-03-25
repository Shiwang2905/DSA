package com.shiwang.dsabootcamp.datastructures.matrix;

import org.w3c.dom.ls.LSOutput;

public class Basics {

    public static void main(String[] args) {


        int[][] matrix = {{1, 1, 1, 1},
                {2, 2, 2, 2},
        {3, 3, 3, 3},
    {4, 4, 4, 4}};

//        traverse(matrix, 0, 0);
//        reverse(matrix, 2, 2);
        transpose(matrix);
        traverse(matrix, 0, 0);
        // Print the matrix

    }

    static void reverse(int[][] arr, int row, int column){


        if(row == 0 && column == 0){
            System.out.println(arr[row][column]);
            return;
        }

        System.out.println(arr[row][column]);
        if(column > 0){
            reverse(arr, row, column - 1);
        }
        if(column == 0){
            reverse(arr, row - 1, arr[0].length - 1);
        }
    }

    static void traverse(int[][] mat, int i, int j) {

        // If the current position is the bottom-right
        // corner of the matrix
        if (i == mat.length - 1 && j == mat[0].length - 1) {
            System.out.println(mat[i][j]);
            return;
        }

        // Print the value at the current position
        System.out.print(mat[i][j] + " ");

        // If the end of the current row has not
        // been reached
        if (j < mat[0].length - 1) {

            // Move right
            traverse(mat, i, j + 1);
        }

        // If the end of the current column has been reached
        else if (i < mat.length - 1) {

            // Move down to the next row
            System.out.println();
            traverse(mat, i + 1, 0);
        }
    }

    static void transpose(int[][] arr){

        for(int i = 0; i < arr.length; i++){
            for(int j =i; j < arr[0].length; j++){

                if(i != j) {
                    int temp = arr[i][j];
                    arr[i][j] = arr[j][i];
                    arr[j][i] = temp;
                }
            }
        }
    }
}
