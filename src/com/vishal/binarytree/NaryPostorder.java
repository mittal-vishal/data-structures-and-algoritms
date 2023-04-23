package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.List;

public class NaryPostorder {

    public List<Integer> postorder(NaryNode root) {
        List<Integer> result = new ArrayList<>();
        postorder(root, result);
        return result;
    }

    private void postorder(NaryNode root, List<Integer> result){
        if(root == null){
            return;
        }
        for(NaryNode node: root.children){
            postorder(node, result);
        }
        result.add(root.val);
    }

}
