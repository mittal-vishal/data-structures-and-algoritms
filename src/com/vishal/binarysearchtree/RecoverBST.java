package com.vishal.binarysearchtree;

public class RecoverBST {

    private TreeNode first;
    private TreeNode second;
    private TreeNode last;
    private TreeNode prev;

    public void recoverTree(TreeNode root) {
        dfs(root);
        if(last == null){
            int temp = first.val;
            first.val = second.val;
            second.val = temp;
        }else{
            int temp = first.val;
            first.val = last.val;
            last.val = temp;
        }
    }

    private void dfs(TreeNode root){
        if(root == null){
            return;
        }
        dfs(root.left);
        //If violation
        if(prev != null && prev.val > root.val){
            //check for first
            if(first == null){
                first = prev;
                second = root;
            }else{
                last = root;
            }
            //check for last
        }
        prev = root;
        dfs(root.right);
    }

}
