package com.vishal.microsoft;

public class KnightProbability {

    public double knightProbability(int n, int k, int row, int column) {
        double[][] curr = new double[n][n];
        double[][] next = new double[n][n];
        curr[row][column] = 1;
        int[][] dirs = {{-2,1},{-1,2},{1,2},{2,1},{2,-1},{1,-2},{-1,-2},{-2,-1}};
        for(int move = 0; move < k; move++){
            for(int i = 0; i < n; i++){
                for(int j = 0; j < n; j++){
                    for(int[] dir: dirs){
                        int newI = i + dir[0];
                        int newJ = j + dir[1];
                        if(isValid(newI, newJ, n)){
                            next[newI][newJ] += curr[i][j]/8.0;
                        }
                    }
                }
            }
            curr = next;
            next = new double[n][n];
        }
        double result = 0d;
        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                result += curr[i][j];
            }
        }
        return result;
    }

    private boolean isValid(int i, int j, int n){
        if(i >= 0 && i < n && j >= 0 && j < n){
            return true;
        }
        return false;
    }

}
