package com.vishal.amazon;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TotalImbalance {

    public long getTotalImbalance(List<Integer> weight) {
        if(weight == null || weight.size() == 0) {
            return 0;
        }
        int row = weight.size(), col = weight.size();
        long[][] min = new long[row][col], max = new long[row][col];
        for(int i=0; i<row; i++) {
            min[i][i] = weight.get(i);
            max[i][i] = weight.get(i);
        }
        for(int k=1; k<row; k++) {
            int i=0, j=k;
            while(j<col) {
                min[i][j] = Math.min(min[i][j-1], min[i+1][j]);
                max[i][j] = Math.max(max[i][j-1], max[i+1][j]);
                i++;
                j++;
            }
        }

        long res = 0;
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                res += max[i][j] - min[i][j];
            }
        }
        return res;
    }

    public static void main(String[] args) {
        List<Integer> weights = Arrays.asList(1,2,3);
        TotalImbalance imbalance = new TotalImbalance();
        System.out.println(imbalance.getTotalImbalance(weights));
    }

}
/*
1,2,3

1,2,3
1,1,1
* */
