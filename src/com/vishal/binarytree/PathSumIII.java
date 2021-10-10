package com.vishal.binarytree;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

    private int count;
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        Map<Integer, Integer> prefixCountMap = new HashMap<>();
        prefixCountMap.put(0, 1);
        getCountPathSum(root, targetSum, 0, prefixCountMap);
        return count;
    }

    private void getCountPathSum(TreeNode root, int targetSum, int currSum, Map<Integer, Integer> prefixCountMap){
        if(root == null){
            return;
        }
        currSum += root.val;
        if(prefixCountMap.containsKey(currSum-targetSum)){
            count += prefixCountMap.get(currSum-targetSum);
        }
        prefixCountMap.put(currSum, prefixCountMap.getOrDefault(currSum, 0) + 1);
        getCountPathSum(root.left, targetSum, currSum, prefixCountMap);
        getCountPathSum(root.right, targetSum, currSum, prefixCountMap);
        prefixCountMap.put(currSum, prefixCountMap.get(currSum) - 1);
    }

}
