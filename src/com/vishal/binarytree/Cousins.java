package com.vishal.binarytree;

public class Cousins {

    private static TreeNode rootNode;
    private TreeNode xParent;
    private TreeNode yParent;
    private int xDepth;
    private int yDepth;

    public boolean isCousins(TreeNode root, int x, int y) {
        dfs(root, 0, x, y, null);
        if(xDepth == yDepth && xParent != yParent){
            return true;
        }else{
            return false;
        }
    }

    private void dfs(TreeNode root, int depth, int x, int y, TreeNode parent){
        if(root == null){
            return;
        }
        if(root.val == x){
            xDepth = depth;
            xParent = parent;
        }else if(root.val == y){
            yDepth = depth;
            yParent = parent;
        }

        dfs(root.left, depth + 1, x, y, root);
        dfs(root.right, depth + 1, x, y, root);
    }

    public static void main(String[] args) {
        rootNode = new TreeNode(1);
        rootNode.setLeft(new TreeNode(2));
        rootNode.setRight(new TreeNode(3));
        rootNode.getLeft().setRight(new TreeNode(4));
        rootNode.getRight().setRight(new TreeNode(5));
        Cousins cousins = new Cousins();
        boolean isCousins = cousins.isCousins(rootNode, 4, 5);
        System.out.println(isCousins);
    }
}