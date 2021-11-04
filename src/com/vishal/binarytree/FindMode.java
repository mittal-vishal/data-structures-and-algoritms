package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindMode {

    private int max;
    public int[] findMode(TreeNode root) {
        Map<Integer, Integer> modeMap = new HashMap<>();
        max = 0;
        dfs(root, modeMap);
        List<Integer> modeList = new ArrayList<>();
        int index = 0;
        for(Map.Entry<Integer, Integer> entry: modeMap.entrySet()){
            if(entry.getValue() == max){
                modeList.add(entry.getKey());
            }
        }
        int[] modes = new int[modeList.size()];
        for(int mode: modeList){
            modes[index++] = mode;
        }
        return modes;
    }

    private void dfs(TreeNode root, Map<Integer, Integer> modeMap){
        if(root == null){
            return;
        }
        int currNodeCount = modeMap.getOrDefault(root.val, 0) + 1;
        max = Math.max(max, currNodeCount);
        modeMap.put(root.val, currNodeCount);
        dfs(root.left, modeMap);
        dfs(root.right, modeMap);
    }

}
