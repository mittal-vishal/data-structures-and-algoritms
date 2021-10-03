package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectLevelOrderSiblings {

    static class Node{
        int val;
        Node left;
        Node right;
        Node next;
    }

    public static void connect(Node root) {
        if(root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        Node prevNode = null;
        Node currNode = null;
        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                currNode = queue.poll();
                if(prevNode != null){
                    prevNode.next = currNode;
                }
                if(currNode.left != null){
                    queue.offer(currNode.left);
                }
                if(currNode.right != null){
                    queue.offer(currNode.right);
                }
                prevNode = currNode;
            }
        }
    }

}
