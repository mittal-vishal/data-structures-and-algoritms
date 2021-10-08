package com.vishal.binarytree;

import java.util.HashMap;
import java.util.Map;

public class PathSumIII {

    private int count;
    public int pathSum(TreeNode root, int targetSum) {
        count = 0;
        Map<Integer, Integer> prefixOccurMap = new HashMap<>();
        prefixOccurMap.put(0, 1);
        int currSum = 0;
        getCountPathSum(root, targetSum, currSum, prefixOccurMap);
        return count;
    }

    private void getCountPathSum(TreeNode root, int targetSum, int currSum, Map<Integer, Integer> prefixOccurMap){
        if(root == null){
            return;
        }
        currSum += root.val;
        if(prefixOccurMap.containsKey(currSum - targetSum)){
            count += prefixOccurMap.get(currSum - targetSum);
        }
        prefixOccurMap.put(currSum, prefixOccurMap.getOrDefault(currSum, 0) + 1);
        getCountPathSum(root.left, targetSum, currSum, prefixOccurMap);
        getCountPathSum(root.right, targetSum, currSum, prefixOccurMap);
        prefixOccurMap.put(currSum, prefixOccurMap.get(currSum) - 1);
    }

}
