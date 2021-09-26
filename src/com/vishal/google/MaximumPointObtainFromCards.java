package com.vishal.google;

public class MaximumPointObtainFromCards {

    public int maxScore(int[] cardPoints, int k) {
        int n = cardPoints.length;
        if(n == 0){
            return 0;
        }
        int slidingSum = 0;
        for(int i = n-k; i < n; i++){
            slidingSum += cardPoints[i];
        }
        int maxPoints = slidingSum;
        int left = 0;
        for(int i = n-k; i < n; i++){
            slidingSum -= cardPoints[i];
            slidingSum += cardPoints[left++];
            maxPoints = Math.max(maxPoints, slidingSum);
        }
        return maxPoints;
    }

}
