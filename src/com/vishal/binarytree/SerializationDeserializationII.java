package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.List;

public class SerializationDeserializationII {

    // Encodes a tree to a single string.
    public String serialize(NaryNode root) {
        StringBuilder sb = new StringBuilder();
        if(root == null){
            return "";
        }
        preorder(root, sb);
        sb.deleteCharAt(sb.length()-1);
        return sb.toString();
    }

    private void preorder(NaryNode root, StringBuilder sb){
        sb.append(root.val + ",");
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
        LinkedList<NaryNode> nodeList = new LinkedList<>();
        for(int i = 0; i < nodes.length-1; i++){
            String rootVal = nodes[i];
            if(rootVal.equals("null")){
                NaryNode polled = nodeList.removeFirst();
                nodeList.getFirst().children.add(polled);
            }else{
                NaryNode currNode = new NaryNode(Integer.parseInt(rootVal));
                currNode.children = new LinkedList<>();
                nodeList.addFirst(currNode);
            }
        }
        return nodeList.removeFirst();
    }

}
