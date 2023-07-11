package com.vishal.stack;

import java.util.*;

public class NumberOfAtoms {

    public String countOfAtoms(String formula) {
        int n = formula.length();
        Stack<HashMap<String,Integer>> stack = new Stack<>();
        stack.push(new HashMap<>());
        Stack<Integer> numStack = new Stack<>();
        StringBuilder charSb = new StringBuilder();
        StringBuilder numSb = new StringBuilder();
        for(int i = n-1; i >= 0; i--){
            char ch = formula.charAt(i);
            if(Character.isDigit(ch)){
                numSb.append(ch);
            }else if(ch == ')'){
                stack.push(new HashMap<>());
                numStack.push(getNum(numSb));
                numSb.setLength(0);
            }else if(Character.isLowerCase(ch)){
                charSb.append(ch);
            }else if(ch == '('){
                Map<String,Integer> map = stack.pop();
                int num = numStack.pop();
                for(Map.Entry<String,Integer> entry: map.entrySet()){
                    if(stack.peek().containsKey(entry.getKey())){
                        stack.peek().put(entry.getKey(), stack.peek().get(entry.getKey()) + entry.getValue() * num);
                    }else{
                        stack.peek().put(entry.getKey(), entry.getValue() * num);
                    }
                }
            }else{
                charSb.append(ch);
                String atom = charSb.reverse().toString();
                int num = getNum(numSb);
                if(stack.peek().containsKey(atom)){
                    stack.peek().put(atom, stack.peek().get(atom) + num);
                }else{
                    stack.peek().put(atom, num);
                }
                numSb.setLength(0);
                charSb.setLength(0);
            }
        }
        Map<String,Integer> atomOccurances = stack.pop();
        List<String> atomList = new ArrayList<>(atomOccurances.keySet());
        Collections.sort(atomList);
        StringBuilder result = new StringBuilder();
        for(String atom: atomList){
            int atomOccurance = atomOccurances.get(atom);
            result.append(atom);
            if(atomOccurance > 1){
                result.append(atomOccurance);
            }
        }
        return result.toString();
    }

    private int getNum(StringBuilder sb){
        return sb.length() == 0 ? 1: Integer.valueOf(sb.reverse().toString());
    }

}
