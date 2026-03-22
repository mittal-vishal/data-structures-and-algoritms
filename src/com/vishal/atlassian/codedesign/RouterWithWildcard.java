package com.vishal.atlassian.codedesign;

/*
* Problem Statement -
Design a Generic Router that handles routing for routes mapped to strings. Routes can support wildcards too. Interface methods expected -
addRoute(route, data) -> None - Add a new route to the Router
route(route) -> str - Returns the string data corresponding to the route queried

Eg. jira.atlassian.com/testRoute/* should be able to route jira.atlassian.com/testRoute/xyz, jira.atlassian.com/testRoute/abc
* */

import java.util.HashMap;

public class RouterWithWildcard {

    public static void main(String[] args) {
        RouterWithWildcard router = new RouterWithWildcard();

        router.addRoute("jira.atlassian.com/testRoute/*", "WildcardRoute");
        router.addRoute("jira.atlassian.com/testRoute/xyz", "ExactXYZ");
        router.addRoute("jira.atlassian.com/home", "HomePage");

        System.out.println(router.route("jira.atlassian.com/testRoute/xyz"));   // ExactXYZ
        System.out.println(router.route("jira.atlassian.com/testRoute/abc"));   // WildcardRoute
        System.out.println(router.route("jira.atlassian.com/home"));            // HomePage
        System.out.println(router.route("jira.atlassian.com/unknown"));         // null
        System.out.println(router.route("jira.atlassian.com/home/"));           // HomePage (trailing slash)
    }

    static class Node{
        private HashMap<String,Node> childrens;
        String data;
        public Node(){
            childrens = new HashMap<>();
        }
    }

    private Node root;

    public RouterWithWildcard(){
        root = new Node();
    }

    public void addRoute(String route, String data){
        Node curr = root;
        String[] paths = route.split("\\/");
        for(String path: paths){
            if(path.isEmpty()){
                continue;
            }
            curr.childrens.putIfAbsent(path, new Node());
            curr = curr.childrens.get(path);
        }
        curr.data = data;
    }

    public String route(String path){
        Node curr = root;
        String[] parts = path.split("\\/");
        return dfs(curr, parts, 0);
    }

    private String dfs(Node curr, String[] parts, int i) {
        if(i == parts.length){
            return curr.data;
        }
        String currPart = parts[i];
        if(curr.childrens.containsKey(currPart)){
            return dfs(curr.childrens.get(currPart), parts, i+1);
        }else if(curr.childrens.containsKey("*")){
            return dfs(curr.childrens.get("*"), parts, i+1);
        }
        return null;
    }

    public boolean deleteRoute(String route){
        Node curr = root;
        String[] paths = route.split("\\/");
        return delete(paths, 0, curr);
    }

    private boolean delete(String[] paths, int i, Node curr) {

        if(i == paths.length){
            if(curr == null || curr.data == null){
                return false;
            }
            curr.data = null;
            return curr.childrens.isEmpty();
        }
        String currPath = paths[i];
        if(currPath.isEmpty()){
            return false;
        }
        Node child = curr.childrens.get(currPath);
        if(child == null){
            return false;
        }
        boolean isChildDeleted = delete(paths, i+1, child);
        if(isChildDeleted){
            curr.childrens.remove(currPath);
            return curr.childrens.isEmpty() && curr.data == null;
        }
        return false;
    }

}
