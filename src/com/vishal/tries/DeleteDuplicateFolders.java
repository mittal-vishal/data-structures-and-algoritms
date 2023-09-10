package com.vishal.tries;

import java.util.*;
import java.util.stream.Collectors;

public class DeleteDuplicateFolders {

    public static void main(String[] args) {
        List<List<String>> paths = new ArrayList<>();
        List<String> path1 = Arrays.asList("a");
        List<String> path2 = Arrays.asList("c");
        List<String> path3 = Arrays.asList("d");
        List<String> path4 = Arrays.asList("a","b");
        List<String> path5 = Arrays.asList("c","b");
        List<String> path6 = Arrays.asList("d","a");
        paths.add(path1);
        paths.add(path2);
        paths.add(path3);
        paths.add(path4);
        paths.add(path5);
        paths.add(path6);
        DeleteDuplicateFolders deleteDuplicateFolders = new DeleteDuplicateFolders();
        System.out.println(deleteDuplicateFolders.deleteDuplicateFolder(paths));
    }

    static class Node{
        String val;
        HashMap<String,Node> childs;
        String dirStructure;
        Node(String val){
            this.val = val;
            childs = new HashMap<>();
        }
    }

    private Node root;

    public List<List<String>> deleteDuplicateFolder(List<List<String>> paths) {
        root = new Node("/");
        List<List<String>> results = new ArrayList<>();
        for(List<String> path: paths){
            createTrie(root, path);
        }
        HashMap<String,Boolean> duplicateStructures = new HashMap<>();
        getDuplicateStructure(root, duplicateStructures);
        removeDuplicateStructure(root, duplicateStructures);
        getResult(root, new ArrayList<>(), results);
        return results;
    }

    private void createTrie(Node root, List<String> path){
        for(String s: path){
            if(!root.childs.containsKey(s)){
                root.childs.put(s, new Node(s));
            }
            root = root.childs.get(s);
        }
    }

    private String getDuplicateStructure(Node root, HashMap<String,Boolean> duplicateStructure){
        List<Node> children = new ArrayList<>(root.childs.values());
        Collections.sort(children, (a, b) -> a.val.compareTo(b.val));
        ArrayList<String> str = new ArrayList<>();
        for(Node node: children){
            String subStructure = getDuplicateStructure(node, duplicateStructure);
            if(subStructure.length() > 0 && duplicateStructure.containsKey(subStructure)){
                duplicateStructure.put(subStructure, true);
            }else{
                duplicateStructure.put(subStructure, false);
            }
            str.add(subStructure + node.val);
        }
        root.dirStructure = str.stream().map(string -> "("+string+")").collect(Collectors.joining("-"));
        return root.dirStructure;
    }

    private void removeDuplicateStructure(Node root, HashMap<String,Boolean> duplicateStructures){
        for(Map.Entry<String,Node> entry: root.childs.entrySet()){
            if(entry.getValue().dirStructure != null && duplicateStructures.get(entry.getValue().dirStructure)){
                root.childs.put(entry.getKey(), null);
            }
            if(root.childs.get(entry.getKey()) != null){
                removeDuplicateStructure(root.childs.get(entry.getKey()), duplicateStructures);
            }
        }
    }

    private void getResult(Node root, List<String> result, List<List<String>> results){
        for(Node node: root.childs.values()){
            if(node != null){
                result.add(node.val);
                results.add(new ArrayList<>(result));
                getResult(node, result, results);
                result.remove(result.size()-1);
            }
        }
    }

}
