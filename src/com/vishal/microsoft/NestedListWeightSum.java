package com.vishal.microsoft;

import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class NestedListWeightSum {

    public int depthSumInverse(List<NestedInteger> nestedList) {
        List<Map.Entry<Integer, Integer>> elementEntryList = new ArrayList<>();
        dfs(nestedList, elementEntryList, 1);
        int ans = 0;
        int maxDepth = 1;
        for(Map.Entry<Integer, Integer> entry: elementEntryList){
            maxDepth = Math.max(maxDepth, entry.getValue());
        }
        for(Map.Entry<Integer, Integer> entry: elementEntryList){
            int weight = (maxDepth - entry.getValue()) + 1;
            ans += (weight * entry.getKey());
        }
        return ans;
    }

    private void dfs(List<NestedInteger> nestedList, List<Map.Entry<Integer, Integer>> elementEntryList, int depth){
        for(int i = 0; i < nestedList.size(); i++){
            if(nestedList.get(i).isInteger()){
                elementEntryList.add(new AbstractMap.SimpleEntry<>(nestedList.get(i).getInteger(), depth));
            }else{
                dfs(nestedList.get(i).getList(), elementEntryList, depth + 1);
            }
        }
    }

}
