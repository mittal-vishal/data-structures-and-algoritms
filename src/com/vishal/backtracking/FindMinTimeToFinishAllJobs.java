package com.vishal.backtracking;

public class FindMinTimeToFinishAllJobs {

    private int result;
    private int[] count;

    public int minimumTimeRequired(int[] jobs, int k) {
        result = Integer.MAX_VALUE;
        count = new int[k];
        backtrack(jobs, 0, k);
        return result;
    }

    private void backtrack(int[] jobs, int i, int k){
        if(i == jobs.length){
            int max = 0;
            for(int j = 0; j < count.length; j++){
                max = Math.max(max, count[j]);
            }
            result = Math.min(result, max);
            return;
        }
        for(int j = 0; j < k; j++){
            count[j] += jobs[i];
            backtrack(jobs, i+1, k);
            count[j] -= jobs[i];
            if(count[j] == 0){
                break;
            }
        }
    }

}
