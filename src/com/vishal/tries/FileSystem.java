package com.vishal.tries;

import java.util.*;

class FileSystem {

    static class File{
        HashMap<String, File> childrens;
        String content;
        boolean isFile;
        public File(){
            this.childrens = new HashMap<>();
            this.content = "";
            this.isFile = false;
        }
    }

    private File root;

    public FileSystem() {
        root = new File();
    }

    public List<String> ls(String path) {
        File curr = root;
        List<String> files = new ArrayList<>();
        if(!path.equals("/")){
            String[] paths = path.split("\\/");
            for(int i = 1; i < paths.length; i++){
                if(curr.childrens.containsKey(paths[i])){
                    curr = curr.childrens.get(paths[i]);
                }
            }
            if(curr.isFile){
                files.add(paths[paths.length - 1]);
                return files;
            }
        }
        List<String> ans = new ArrayList<>(curr.childrens.keySet());
        Collections.sort(ans);
        return ans;
    }

    public void mkdir(String path) {
        File curr = root;
        String[] paths = path.split("\\/");
        for(int i = 1; i < paths.length; i++){
            if(!curr.childrens.containsKey(paths[i])){
                curr.childrens.put(paths[i], new File());
            }
            curr = curr.childrens.get(paths[i]);
        }
    }

    public void addContentToFile(String filePath, String content) {
        File curr = root;
        String[] paths = filePath.split("\\/");
        for(int i = 1; i < paths.length - 1; i++){
            curr = curr.childrens.get(paths[i]);
        }
        if(!curr.childrens.containsKey(paths[paths.length - 1])){
            curr.childrens.put(paths[paths.length - 1], new File());
        }
        curr = curr.childrens.get(paths[paths.length - 1]);
        curr.isFile = true;
        curr.content = curr.content + content;
    }

    public String readContentFromFile(String filePath) {
        File curr = root;
        String[] paths = filePath.split("\\/");
        for(int i = 1; i < paths.length; i++){
            curr = curr.childrens.get(paths[i]);
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

