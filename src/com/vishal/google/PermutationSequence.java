package com.vishal.google;

import java.util.ArrayList;
import java.util.List;

public class PermutationSequence {

    public String getPermutation(int n, int k) {
        List<Integer> numbers = new ArrayList<>();
        int factorial = 1;
        for(int i = 1; i < n; i++){
            factorial *= i;
            numbers.add(i);
        }
        numbers.add(n);
        StringBuilder result = new StringBuilder();
        k -= 1;
        while(true){
            int digit = numbers.get(k/factorial);
            result.append(digit);
            numbers.remove(k/factorial);
            if(numbers.size() == 0){
                break;
            }
            k =  k % factorial;
            factorial /= numbers.size();
        }
        return result.toString();
    }

}
