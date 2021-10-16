package com.vishal.recursion;

import java.util.ArrayList;
import java.util.List;

public class GenerateParenthsis {

    public List<String> generateParenthesis(int n) {
        List<String> balancedList = new ArrayList<>();
        generateParenthesis(n, n, "", balancedList);
        return balancedList;
    }

    private void generateParenthesis(int left, int right, String parenthesis, List<String> balancedList){
        if(left == 0 && right == 0){
            balancedList.add(parenthesis);
            return;
        }
        if(left > 0){
            generateParenthesis(left - 1, right, parenthesis + "(", balancedList);
        }
        if(right > left){
            generateParenthesis(left, right - 1, parenthesis + ")", balancedList);
        }
    }

}
