package com.vishal.binarytree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class SerializationDeserializationII {

    public String serialize(NaryNode root) {
        if(root == null){
            return "";
        }
        StringBuilder sb = new StringBuilder();
        preorder(root, sb);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private void preorder(NaryNode root, StringBuilder sb){
        sb.append(root.val).append(",");
        for(NaryNode child: root.children){
            preorder(child, sb);
        }
        sb.append("null,");
    }

    // Decodes your encoded data to tree.
    public NaryNode deserialize(String data) {
        if(data.length() == 0){
            return null;
        }
        String[] nodes = data.split(",");
        LinkedList<NaryNode> linkedList = new LinkedList<>();
        for(int i = 0; i < nodes.length-1; i++){
            String currNode = nodes[i];
            if(currNode.equals("null")){
                NaryNode polled = linkedList.removeFirst();
                linkedList.getFirst().children.add(polled);
            }else{
                NaryNode node = new NaryNode(Integer.valueOf(currNode));
                node.children = new ArrayList<>();
                linkedList.addFirst(node);
            }
        }
        return linkedList.removeFirst();
    }

}
