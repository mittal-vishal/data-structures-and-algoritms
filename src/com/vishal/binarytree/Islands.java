package com.vishal.binarytree;

import java.util.ArrayList;

class Islands{

    static class TreeNode{
        int val;
        ArrayList<TreeNode> childrens;
        public TreeNode(int val){
            this.val = val;
            childrens = new ArrayList<>();
        }
    }

    private int count;

    public int countIslands(TreeNode root){
        dfs(root, null);
        return count;
    }

    private void dfs(TreeNode root, TreeNode parent){
        if(parent == null && root.val == 1 ||
                root.val == 1 && parent.val == 0){
            count++;
        }
        for(TreeNode child: root.childrens){
            dfs(child, root);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.childrens.add(new TreeNode(0));
        root.childrens.add(new TreeNode(0));
        root.childrens.get(0).childrens.add(new TreeNode(0));
        root.childrens.get(0).childrens.add(new TreeNode(1));
        root.childrens.get(0).childrens.get(1).childrens.add(new TreeNode(0));
        root.childrens.get(0).childrens.get(1).childrens.add(new TreeNode(1));
        root.childrens.get(1).childrens.add(new TreeNode(0));
        root.childrens.get(1).childrens.add(new TreeNode(0));
        root.childrens.get(1).childrens.add(new TreeNode(1));
        root.childrens.get(1).childrens.get(2).childrens.add(new TreeNode(0));
        root.childrens.get(1).childrens.get(2).childrens.add(new TreeNode(0));
        root.childrens.get(1).childrens.get(2).childrens.add(new TreeNode(1));
        root.childrens.get(1).childrens.get(2).childrens.get(2).childrens.add(new TreeNode(1));
        Islands islands = new Islands();
        int count = islands.countIslands(root);
        System.out.println(count);
    }

}
