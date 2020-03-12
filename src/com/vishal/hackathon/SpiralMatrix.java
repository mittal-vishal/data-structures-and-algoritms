package com.vishal.hackathon;

import java.util.Scanner;

public class SpiralMatrix {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            int m = sc.nextInt();
            int n = sc.nextInt();
            String str = sc.next();
            findSpiral(m, n, str);
        }
        sc.close();
    }
    
    private static void findSpiral(int m, int n, String str){
        int startingRow = 0; 
        int startingCol = 0;
        int count = 0;
        int originalM = m;
        int originalN = n;
        char[][] a = new char[m][n];
        while (startingRow < m && startingCol < n) { 
            for (int i = startingCol; i < n; ++i) { 
                a[startingRow][i] = str.charAt((count++)%(str.length()));
            } 
            startingRow++; 
  
            for (int i = startingRow; i < m; ++i) { 
                a[i][n - 1] = str.charAt((count++)%(str.length()));
            } 
            n--; 
  
            for (int i = n - 1; i >= startingCol; --i) { 
                a[m - 1][i] = str.charAt((count++)%(str.length()));
            } 
            m--;
  
            for (int i = m - 1; i >= startingRow; --i) { 
                a[i][startingCol] = str.charAt((count++)%(str.length()));
            } 
            startingCol++;
        }
        for(int i = 0; i < originalM; i++){
            for(int j = 0; j < originalN; j++){
                System.out.print(a[i][j]);
            }
            System.out.println();
        }
    }
}