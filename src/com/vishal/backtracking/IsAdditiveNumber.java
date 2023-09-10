package com.vishal.backtracking;

public class IsAdditiveNumber {

    public boolean isAdditiveNumber(String num) {
        return backtrack(num, 0, 0L, 0L, 0);
    }

    private boolean backtrack(String num, int index, Long prev, Long sum, int length){
        //base case
        if(index == num.length()){
            return length > 2;
        }
        Long curr = 0L;
        for(int i = index; i < num.length(); i++){
            //skip leading 0
            if(i > index && num.charAt(index) == '0'){
                break;
            }
            curr = curr * 10 + num.charAt(i)-'0';
            if(length > 1){
                if(curr > sum){
                    break;
                }else if(curr < sum){
                    continue;
                }
            }
            sum = curr + prev;
            if(backtrack(num, i+1, curr, sum, length+1)){
                return true;
            }
            sum -= curr + prev;
        }
        return false;
    }

}
