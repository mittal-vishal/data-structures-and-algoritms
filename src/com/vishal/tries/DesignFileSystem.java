package com.vishal.tries;

import java.util.HashMap;

public class DesignFileSystem {

    static class Node{
        HashMap<String,Node> childs;
        int val;
        public Node(){
            childs = new HashMap<>();
        }
    }

    private Node root;

    public DesignFileSystem() {
        root = new Node();
    }

    public boolean createPath(String path, int value) {
        String[] pathValues = path.split("\\/");
        String newPath = pathValues[pathValues.length-1];
        Node curr = root;
        for(int i = 1; i < pathValues.length-1; i++){
            String pathVal = pathValues[i];
            if(!curr.childs.containsKey(pathVal)){
                return false;
            }
            curr = curr.childs.get(pathVal);
        }
        if(curr.childs.containsKey(newPath)){
            return false;
        }
        curr.childs.put(newPath, new Node());
        curr = curr.childs.get(newPath);
        curr.val = value;
        return true;
    }

    public int get(String path) {
        String[] pathValues = path.split("\\/");
        Node curr = root;
        for(int i = 1; i < pathValues.length; i++){
            String pathVal = pathValues[i];
            if(!curr.childs.containsKey(pathVal)){
                return -1;
            }
            curr = curr.childs.get(pathVal);
        }
        return curr.val;
    }

}
