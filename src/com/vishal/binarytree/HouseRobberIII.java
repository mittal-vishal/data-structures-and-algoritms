package com.vishal.binarytree;

import java.util.HashMap;
import java.util.Map;

public class HouseRobberIII {

    Map<TreeNode, Integer> memo;

    public int rob(TreeNode root) {
        memo = new HashMap<>();
        return getMaxMoney(root);
    }

    private int getMaxMoney(TreeNode root){
        if(memo.containsKey(root)){
            return memo.get(root);
        }
        if(root == null){
            return 0;
        }
        int robbed = root.val;
        if(root.left != null){
            robbed += getMaxMoney(root.left.left) + getMaxMoney(root.left.right);
        }
        if(root.right != null){
            robbed += getMaxMoney(root.right.left) + getMaxMoney(root.right.right);
        }

        int notRobbed = getMaxMoney(root.left) + getMaxMoney(root.right);
        int maxMoney = Math.max(robbed, notRobbed);
        memo.put(root, maxMoney);
        return memo.get(root);
    }

}
