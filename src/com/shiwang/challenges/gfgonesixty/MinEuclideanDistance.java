package com.shiwang.challenges.gfgonesixty;

public class MinEuclideanDistance {

    public static void main(String[] args) {
        double[][] points = {{-2, -2}, {1, 2}, {-1, 0}, {3, 3}};
        MinEuclideanDistance med = new MinEuclideanDistance();
        double distance = med.getDistance(points);
        System.out.println("Minimum Euclidean Distance: " + distance);
    }

    double getDistance(double[][] array){

        if(array.length == 1){
            return Double.MAX_VALUE; // No distance to calculate with a single point
        }
        if(array.length == 2){
            return calculateDistance(array[0], array[1]);
        }
        int end = array.length;
        int mid = end / 2;
        double[][] left = new double[mid][2];
        double[][] right = new double[end - mid][2];

        for(int i = 0; i < mid; i++){
            left[i] = array[i];
        }
        for(int i = 0; i < end - mid; i++){
            right[i] = array[mid + i];
        }

        double leftDist = getDistance(left);
        double rightDist = getDistance(right);
        return mergeDist(left, right, Math.min(leftDist, rightDist));
    }

    double mergeDist(double[][] left, double[][] right, double minDist) {
        int i = 0, j = 0;
        while (i < left.length && j < right.length) {
            double tempDist = calculateDistance(left[i], right[j]);
            if (tempDist <= minDist) {
                minDist = tempDist;
                j++;
            } else {
                i++;
            }
        }
        return minDist;
    }

    double calculateDistance(double[] point1, double[] point2) {
        double firstDiff = point1[0] - point2[0];
        double secondDiff = point1[1] - point2[1];
        return Math.sqrt(Math.pow(firstDiff, 2) + Math.pow(secondDiff, 2));
    }
}
