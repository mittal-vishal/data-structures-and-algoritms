package com.vishal.microsoft;

import java.util.ArrayList;
import java.util.List;


/**
 * After deleteing 5, obtain largest number
 */
public class Delete5FromNumber {

    public static void main(String[] args) {
        System.out.println(delete5FromNumber(65857)); // 857
        System.out.println(delete5FromNumber(54351)); // 5431
        System.out.println(delete5FromNumber(545751)); // 54751

    }


    private static int delete5FromNumber(int num) {
        List<Integer> digitList = new ArrayList<>();
        while(num > 0){
            digitList.add(num % 10);
            num /= 10;
        }
        int toBeDeleted = -1;
        for(int i = digitList.size() - 1; i >= 0; i--){
            if(digitList.get(i) == 5){
                if(i > 0 && digitList.get(i-1) > 5){
                    toBeDeleted = i;
                    break;
                }else{
                    toBeDeleted = i;
                }
            }
        }
        int pow = 0;
        int ans = 0;
        for(int i = 0; i < digitList.size(); i++){
            if(i != toBeDeleted){
                ans = ans + (int)(Math.pow(10, pow) * digitList.get(i));
                pow++;
            }
        }
        return ans;
    }

}
