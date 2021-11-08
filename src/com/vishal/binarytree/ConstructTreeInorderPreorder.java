package com.vishal.binarytree;

import java.util.HashMap;
import java.util.Map;

public class ConstructTreeInorderPreorder {

    private int preorderIdx;
    private Map<Integer, Integer> inorderMap;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        preorderIdx = 0;
        inorderMap = new HashMap<>();
        for(int i = 0; i < inorder.length; i++){
            inorderMap.put(inorder[i], i);
        }
        return buildTree(preorder, inorder, 0, inorder.length - 1);
    }

    private TreeNode buildTree(int[] preorder, int[] inorder, int inorderStart, int inorderEnd){
        if(inorderStart > inorderEnd){
            return null;
        }
        TreeNode currNode = new TreeNode(preorder[preorderIdx++]);
        int inorderCurrIdx = inorderMap.get(currNode.val);
        currNode.left = buildTree(preorder, inorder, inorderStart, inorderCurrIdx - 1);
        currNode.right = buildTree(preorder, inorder, inorderCurrIdx + 1, inorderEnd);
        return currNode;
    }

    public static void main(String[] args) {
        ConstructTreeInorderPreorder tree = new ConstructTreeInorderPreorder();
        int[] preorder = {3,9,20,15,7};
        int[] inorder = {9,3,15,20,7};
        TreeNode root = tree.buildTree(preorder, inorder);
        InOrder in = new InOrder();
        in.traverse(root);
    }

}
