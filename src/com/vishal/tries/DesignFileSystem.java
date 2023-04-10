package com.vishal.tries;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem {

    class Node{
        int value;
        Map<String,Node> childrens;
        public Node(){
            childrens = new HashMap<>();
        }
    }

    private Node root;

    public DesignFileSystem() {
        root = new Node();
    }

    public boolean createPath(String path, int value) {
        String[] components = path.split("\\/");
        Node curr = root;
        for(int i = 1; i < components.length; i++){
            String currComponent = components[i];
            if(!curr.childrens.containsKey(currComponent)){
                if(i == components.length - 1){
                    curr.childrens.put(currComponent, new Node());
                }else{
                    return false;
                }
            }
            curr = curr.childrens.get(currComponent);
        }
        if(curr.value == 0){
            curr.value = value;
            return true;
        }
        return false;
    }

    public int get(String path) {
        String[] components = path.split("\\/");
        Node curr = root;
        for(int i = 1; i < components.length; i++){
            String currComponent = components[i];
            if(!curr.childrens.containsKey(currComponent)){
                return -1;
            }
            curr = curr.childrens.get(currComponent);
        }
        return curr.value;
    }

    public static void main(String[] args) {
        DesignFileSystem fileSystem = new DesignFileSystem();
        fileSystem.createPath("/a",1);
        System.out.println(fileSystem.get("/a"));
    }

}
