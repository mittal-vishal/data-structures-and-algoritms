package com.vishal.prefix;

public class PlatesBetweenCandles {

    public int[] platesBetweenCandles(String s, int[][] queries) {
        int n = s.length();
        int[] range = new int[n];
        range[0] = s.charAt(0) == '*' ? 1 : 0;
        for(int i = 1; i < n; i++){
            char ch = s.charAt(i);
            range[i] = range[i-1] + (s.charAt(i) == '*' ? 1 : 0);
        }
        int[] leftCandle = new int[n];
        int[] rightCandle = new int[n];
        int leftCandlePos = -1;
        for(int i = 0; i < n; i++){
            if(s.charAt(i) == '|'){
                leftCandlePos = i;
            }
            leftCandle[i] = leftCandlePos;
        }
        int rightCandlePos = -1;
        for(int i = n-1; i >= 0; i--){
            if(s.charAt(i) == '|'){
                rightCandlePos = i;
            }
            rightCandle[i] = rightCandlePos;
        }
        int[] res = new int[queries.length];
        for(int i = 0; i < queries.length; i++){
            int left = queries[i][0];
            int right = queries[i][1];
            left = rightCandle[left];
            right = leftCandle[right];
            res[i] = left == -1 || right == -1 || left >= right ? 0 : range[right] - range[left];
        }
        return res;
    }

}
