package com.vishal.tries;

import java.util.*;

class FileSystem {

    class Node{
        Map<String,Node> childrens;
        String content;
        boolean isFile;
        public Node(){
            childrens = new HashMap<>();
            content = "";
        }
    }

    private Node root;

    public FileSystem() {
        root = new Node();
    }

    public List<String> ls(String path) {
        List<String> result = new ArrayList<>();
        Node curr = root;
        String[] components = path.split("\\/");
        for(int i = 1; i < components.length; i++){
            String currComponent = components[i];
            if(curr.childrens.containsKey(currComponent)){
                curr = curr.childrens.get(currComponent);
            }
        }
        if(curr.isFile){
            result.add(components[components.length-1]);
            return result;
        }else{
            result = new ArrayList<>(curr.childrens.keySet());
            Collections.sort(result);
            return result;
        }
    }

    public void mkdir(String path) {
        String[] components = path.split("\\/");
        Node curr = root;
        for(int i = 1; i < components.length; i++){
            String currComponent = components[i];
            if(!curr.childrens.containsKey(currComponent)){
                curr.childrens.put(currComponent, new Node());
            }
            curr = curr.childrens.get(currComponent);
        }
    }

    public void addContentToFile(String filePath, String content) {
        String[] components = filePath.split("\\/");
        Node curr = root;
        for(int i = 1; i < components.length-1; i++){
            String currComponent = components[i];
            curr = curr.childrens.get(currComponent);
        }
        if(!curr.childrens.containsKey(components[components.length-1])){
            curr.childrens.put(components[components.length-1], new Node());
        }
        curr = curr.childrens.get(components[components.length-1]);
        curr.isFile = true;
        curr.content += content;
    }

    public String readContentFromFile(String filePath) {
        String[] components = filePath.split("\\/");
        Node curr = root;
        for(int i = 1; i < components.length; i++){
            String currComponent = components[i];
            curr = curr.childrens.get(currComponent);
        }
        return curr.content;
    }

    public static void main(String[] args) {
        FileSystem fs = new FileSystem();
        List<String> rootPath1 = fs.ls("/");
        System.out.println(rootPath1);
        fs.mkdir("/a/b/c");
        fs.addContentToFile("/a/b/c/d","hello world");
        List<String> rootPath2 = fs.ls("/");
        System.out.println(rootPath2);
        String content1 = fs.readContentFromFile("/a/b/c/d");
        System.out.println(content1);
        fs.addContentToFile("/a/b/c/d"," hello hello world");
        String content2 = fs.readContentFromFile("/a/b/c/d");
        System.out.println(content2);
    }
}

