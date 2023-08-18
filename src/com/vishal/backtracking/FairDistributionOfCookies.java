package com.vishal.backtracking;

public class FairDistributionOfCookies {

    private int result;
    private int[] count;

    public int distributeCookies(int[] cookies, int k) {
        count = new int[k];
        result = Integer.MAX_VALUE;
        backtrack(cookies, 0, k);
        return result;
    }

    private void backtrack(int[] cookies, int i, int k){
        if(i == cookies.length){
            int unfairness = 0;
            for(int j = 0; j < count.length; j++){
                unfairness = Math.max(unfairness, count[j]);
            }
            result = Math.min(result, unfairness);
            return;
        }
        for(int j = 0; j < k; j++){
            count[j] += cookies[i];
            backtrack(cookies, i+1, k);
            count[j] -= cookies[i];
            if(count[j] == 0){
                break;
            }
        }
    }

}
