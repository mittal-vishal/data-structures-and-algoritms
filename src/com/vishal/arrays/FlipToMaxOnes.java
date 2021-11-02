package com.vishal.arrays;

public class FlipToMaxOnes {

    public int[] flip(String A) {
        int[] resultant = new int[2];
        int l = 0, r = 0;
        int ans = Integer.MIN_VALUE;
        int counter = 0;
        int L = 0, R = 0;

        //Base Case
        if(A == null || A.length() == 0){
            return new int[]{};
        }
        int oneCount = 0;
        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == '1'){
                oneCount++;
            }
        }
        if(oneCount == A.length()){
            return new int[]{};
        }

        for(int i = 0; i < A.length(); i++){
            if(A.charAt(i) == '0'){
                r = i;
                counter++;
            }else if(A.charAt(i) == '1'){
                counter--;
                if(counter < 0){
                    counter = 0;
                    l = i + 1;
                    r = i + 1;
                }
            }
            if(counter > ans){
                L = l;
                R = r;
                ans = counter;
            }
        }
        resultant[0] = L + 1;
        resultant[1] = R + 1;
        return resultant;
    }

}
