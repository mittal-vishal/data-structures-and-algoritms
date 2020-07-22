package com.vishal.goldmansachs;

import java.util.ArrayList;
import java.util.List;

public class PascalTriangle {
	
	public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> returnList = new ArrayList<>();
        List<Integer> innerList = null;
        for(int i = 0; i < numRows; i++){
            if(i == 0){
                innerList = new ArrayList<>();
                innerList.add(1);
                returnList.add(innerList);
            }else if(i == 1){
                innerList = new ArrayList<>();
                innerList.add(1);
                innerList.add(1);
                returnList.add(innerList);
            }else{
                innerList = new ArrayList<>();
                innerList.add(1);
                List<Integer> prevList = returnList.get(i-1);
                for(int j = 0; j < prevList.size() - 1; j++){
                    innerList.add(prevList.get(j) + prevList.get(j+1));
                }
                innerList.add(1);
                returnList.add(innerList);
            }
        }
        return returnList;
    }
	
}
