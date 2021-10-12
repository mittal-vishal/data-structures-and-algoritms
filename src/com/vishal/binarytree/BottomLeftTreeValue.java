package com.vishal.binarytree;

public class BottomLeftTreeValue {
    private int bottomLeft;
    private int maxLevel;

    public int findBottomLeftValue(TreeNode root) {
        bottomLeft = root.val;
        maxLevel = 0;
        dfs(root, 0);
        return bottomLeft;
    }

    private void dfs(TreeNode root, int level){
        if(root == null){
            return;
        }
        dfs(root.left, level + 1);
        if(level > maxLevel){
            bottomLeft = root.val;
            maxLevel = level;
        }
        dfs(root.right, level + 1);
    }
}
