package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMode {

    private Map<Integer,Integer> occurance;
    private int maxOccurance;

    public int[] findMode(TreeNode root) {
        occurance = new HashMap<>();
        dfs(root);
        List<Integer> modes = new ArrayList<>();
        for(Map.Entry<Integer,Integer> entry: occurance.entrySet()){
            if(entry.getValue() == maxOccurance){
                modes.add(entry.getKey());
            }
        }
        int[] res = new int[modes.size()];
        for(int i = 0; i < modes.size(); i++){
            res[i] = modes.get(i);
        }
        return res;
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        int currElement = root.val;
        occurance.put(currElement, occurance.getOrDefault(currElement, 0) + 1);
        maxOccurance = Math.max(maxOccurance, occurance.get(currElement));
        dfs(root.left);
        dfs(root.right);
    }

}
