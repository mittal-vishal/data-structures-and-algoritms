package com.vishal.binarytree;

import java.util.LinkedList;
import java.util.Queue;

public class ConnectLevels {

    static class Node{
        int val;
        Node left;
        Node right;
        Node next;
    }

    public Node connect(Node root) {
        if(root == null){
            return null;
        }

        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()){
            int size = queue.size();
            for(int i = 0; i < size; i++){
                Node polled = queue.poll();
                polled.next = i < (size-1) ? queue.peek() : null;
                if(polled.left != null){
                    queue.offer(polled.left);
                }
                if(polled.right != null){
                    queue.offer(polled.right);
                }
            }
        }
        return root;
    }

}
