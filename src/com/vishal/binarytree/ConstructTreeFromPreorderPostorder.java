package com.vishal.binarytree;

public class ConstructTreeFromPreorderPostorder {

    private int[] postorderIdx;

    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        int n = postorder.length;
        postorderIdx = new int[n+1];
        for(int i = 0; i < n; i++){
            postorderIdx[postorder[i]] = i;
        }
        return constructTree(preorder, 0, n-1, postorder, 0);
    }

    private TreeNode constructTree(int[] preorder, int preStart, int preEnd, int[] postorder, int postStart){
        if(preStart > preEnd){
            return null;
        }else if(preStart == preEnd){
            return new TreeNode(preorder[preStart]);
        }else{
            int leftRootVal = preorder[preStart+1];
            int leftSubtreeSize = postorderIdx[leftRootVal] - postStart + 1;
            TreeNode root = new TreeNode(preorder[preStart]);
            root.left = constructTree(preorder, preStart+1, preStart + leftSubtreeSize, postorder, postStart);
            root.right = constructTree(preorder, preStart + leftSubtreeSize + 1, preEnd, postorder, postStart + leftSubtreeSize);
            return root;
        }
    }

}
