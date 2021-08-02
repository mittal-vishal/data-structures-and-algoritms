package com.vishal.recursion;

public class PowerOfTwo {

    public static void main(String[] args) {
        int n = 8;
        int ans = getExponentOptimal(6);
        System.out.print(ans);
    }

    private static int getExponent(int pow) {
        if(pow == 0){
            return 1;
        }
        int ans =  2 * getExponent(pow-1);
        return ans;
    }

    //Functions calls are reduced by half every time
    //Height of recursion tree O(logn)
    private static int getExponentOptimal(int pow) {
        if(pow == 0){
            return 1;
        }
        int ans = getExponentOptimal(pow/2);
        if(pow % 2 == 1){
            return 2 * ans * ans;
        }else{
            return ans*ans;
        }
    }

}
