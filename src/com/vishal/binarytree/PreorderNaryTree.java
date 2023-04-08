package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.List;

public class PreorderNaryTree {

    public List<Integer> preorder(NaryNode root) {
        List<Integer> preorderList = new ArrayList<>();
        preorder(root, preorderList);
        return preorderList;
    }

    private void preorder(NaryNode root, List<Integer> preorderList){
        if(root == null){
            return;
        }
        preorderList.add(root.val);
        for(NaryNode node: root.children){
            preorder(node, preorderList);
        }
    }

}
