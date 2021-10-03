package com.vishal.binarytree;

public class BottomLeftTreeValue {
    private int bottomLeft;
    private int maxLevel;

    public int findBottomLeftValue(TreeNode root) {
        bottomLeft = root.val;
        maxLevel = 0;
        dfs(root, 0, false);
        return bottomLeft;
    }

    private void dfs(TreeNode root, int level, boolean isLeft){
        if(root == null){
            return;
        }
        if(root.left == null && root.right == null && isLeft){
            if(level > maxLevel){
                bottomLeft = root.val;
                maxLevel = level;
            }
        }
        dfs(root.left, level + 1, true);
        if(root.left == null){
            dfs(root.right, level + 1, true);
        }else{
            dfs(root.right, level + 1, false);
        }
    }
}
