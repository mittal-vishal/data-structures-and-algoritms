package com.vishal.recursion;

public class PrintSpell {

    public static void main(String[] args) {
        int num = 432;
        String[] nums = {"zero", "one", "two", "three","four",
                "five","six","seven","eight","nine"};
        printSpell(num, nums);
    }

    public static void printSpell(int n, String[] nums){
        if(n == 0){
            return;
        }
        printSpell(n/10, nums);
        String num = nums[n%10];
        System.out.print(num+" ");
    }

}
