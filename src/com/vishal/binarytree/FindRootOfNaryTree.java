package com.vishal.binarytree;

import java.util.HashSet;
import java.util.List;

public class FindRootOfNaryTree {

    public NaryNode findRoot(List<NaryNode> tree) {
        HashSet<NaryNode> seen = new HashSet<>(tree);
        for(NaryNode node: tree){
            //iterate children of each node, and delete childs, root will be left alone
            for(NaryNode child: node.children){
                if(seen.contains(child)){
                    seen.remove(child);
                }
            }
        }
        return !seen.isEmpty()? seen.iterator().next(): null;
    }

}
