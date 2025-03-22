package com.vishal.google;

import java.util.ArrayList;
import java.util.List;

public class ProductOfNumber {

    public static void main(String[] args) {
        ProductOfNumber productOfNumber = new ProductOfNumber();
        productOfNumber.add(3);
        productOfNumber.add(0);
        productOfNumber.add(2);
        productOfNumber.add(5);
        productOfNumber.add(4);
        System.out.println(productOfNumber.getProduct(2));
        System.out.println(productOfNumber.getProduct(3));
        System.out.println(productOfNumber.getProduct(4));
        //[3,0,2,5,4] - [2,3,4]
    }

    private List<Integer> nums;
    private int lastZeroIdx;

    public ProductOfNumber() {
        nums = new ArrayList<>();
        nums.add(1);
    }

    public void add(int num) {
        if(num == 0){
            lastZeroIdx = nums.size();
            nums.add(num);
            return;
        }
        int lastElement = nums.get(nums.size()-1);
        if(lastElement == 0){
            nums.add(num);
        }else{
            nums.add(lastElement*num);
        }
    }

    public int getProduct(int k) {
        int idx = (nums.size()-k)-1;
        if(idx < lastZeroIdx){
            return 0;
        }else{
            int dividend = nums.get(nums.size()-1);
            int divisor = 1;
            if(idx > lastZeroIdx){
                divisor = nums.get(idx);
            }
            return dividend/divisor;
        }
    }

}
