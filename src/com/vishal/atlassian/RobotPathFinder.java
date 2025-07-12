package com.vishal.atlassian;

import java.util.*;

/*
* 🚀 Context:
You work in a robot factory. Once robots are built, they are moved to the shipping center using autonomous delivery carts.

These delivery carts follow one-way paths. Think of each cart route as a directed connection from one station to another.

🎯 Goal:
Given a list of paths that represent directed connections between locations, you are asked to:

Identify all starting locations — places where robots begin their journey (i.e., they don’t have any incoming carts).

For each starting location, find all the final destinations a robot can end up at if it starts from that location. A destination is a location where the robot journey ends (i.e., no outgoing path from there).

🔁 Input Format:
You are given a list of directed edges, each represented as a pair [from, to].

Example:

java
Copy
Edit
paths = [
    ["B", "K"],
    ["C", "K"],
    ["E", "L"],
    ["F", "G"],
    ["J", "M"],
    ["E", "F"],
    ["C", "G"],
    ["A", "B"],
    ["A", "C"],
    ["G", "H"],
    ["G", "I"]
];
This represents a directed graph, e.g.,
A → B → K
A → C → K
C → G → H and I
E → F → G → H and I
J → M
E → L

✅ What You Need to Return:
A mapping of:

Each starting point → the set of all possible end points (leaf nodes) reachable from that starting point.

Expected output:

java
Copy
Edit
{
  "A": ["K", "H", "I"],
  "E": ["L", "H", "I"],
  "J": ["M"]
}
* */
public class RobotPathFinder {

    public static void main(String[] args) {
        List<List<String>> paths = Arrays.asList(
                Arrays.asList("B", "K"),
                Arrays.asList("C", "K"),
                Arrays.asList("E", "L"),
                Arrays.asList("F", "G"),
                Arrays.asList("J", "M"),
                Arrays.asList("E", "F"),
                Arrays.asList("C", "G"),
                Arrays.asList("A", "B"),
                Arrays.asList("A", "C"),
                Arrays.asList("G", "H"),
                Arrays.asList("G", "I")
        );
        Map<String,List<String>> result = findStartToEndPaths(paths);
        System.out.println(result);
    }

    private static Map<String, List<String>> findStartToEndPaths(List<List<String>> paths) {
        Map<String, List<String>> result = new HashMap<>();
        //build graph and calculate inorder
        HashMap<String,List<String>> graph = new HashMap<>();
        HashMap<String,Integer> inDegree = new HashMap<>();
        for(List<String> pair: paths){
            String from = pair.get(0);
            String to = pair.get(1);
            graph.putIfAbsent(from, new ArrayList<>());
            graph.get(from).add(to);
            inDegree.put(to, inDegree.getOrDefault(to, 0) + 1);
            inDegree.put(from, inDegree.getOrDefault(from, 0));
        }
        //dfs for all inorder
        for(Map.Entry<String,Integer> entry: inDegree.entrySet()){
            if(entry.getValue() == 0){
                HashSet<String> destination = new HashSet<>();
                dfs(entry.getKey(), graph, destination);
                result.put(entry.getKey(), new ArrayList(destination));
            }
        }
        return result;
    }

    private static void dfs(String key, HashMap<String, List<String>> graph, HashSet<String> destination) {
        if(!graph.containsKey(key)){
            destination.add(key);
            return;
        }
        for(String neighbor: graph.get(key)){
            dfs(neighbor, graph, destination);
        }
    }

}
