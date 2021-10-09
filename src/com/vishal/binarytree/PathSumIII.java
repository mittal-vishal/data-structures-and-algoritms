package com.vishal.binarytree;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

    private int count;
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        Map<Integer, Integer> prefixCountMap = new HashMap<>();
        prefixCountMap.put(0, 1);
        pathSum(root, 0, targetSum, prefixCountMap);
        return count;
    }

    private void pathSum(TreeNode root, int currSum, int targetSum, Map<Integer, Integer> prefixCountMap){
        if(root == null){
            return;
        }
        currSum += root.val;
        if(prefixCountMap.containsKey(currSum - targetSum)){
            count += prefixCountMap.get(currSum - targetSum);
        }
        prefixCountMap.put(currSum, prefixCountMap.getOrDefault(currSum, 0) + 1);
        pathSum(root.left, currSum, targetSum, prefixCountMap);
        pathSum(root.right, currSum, targetSum, prefixCountMap);
        prefixCountMap.put(currSum, prefixCountMap.get(currSum) - 1);
    }

}
