package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EvaluateDivision {

    private double result;

    static class Node{
        String name;
        double value;
        Node(String name, double value){
            this.name = name;
            this.value = value;
        }
    }

    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Node>> graph = new HashMap<>();
        initializeGraph(graph, equations, values);
        double[] results = new double[queries.size()];
        HashSet<String> visited = new HashSet<>();
        for(int i = 0; i < queries.size(); i++){
            List<String> query = queries.get(i);
            result = -1d;
            dfs(graph, query.get(0), query.get(1), visited, 1d);
            results[i] = result;
        }
        return results;
    }

    private void dfs(HashMap<String, List<Node>> graph, String src, String dest, HashSet<String> visited, double prod){
        if(!graph.containsKey(src) || visited.contains(src)){
            return;
        }else if(src.equals(dest)){
            result = prod;
            return;
        }
        visited.add(src);
        for(Node neighbour: graph.get(src)){
            dfs(graph, neighbour.name, dest, visited, prod * neighbour.value);
        }
        visited.remove(src);
    }

    private void initializeGraph(HashMap<String, List<Node>> graph, List<List<String>> equations, double[] values){
        for(int i = 0; i < equations.size(); i++){
            List<String> equation = equations.get(i);
            double value = values[i];
            String u = equation.get(0);
            String v = equation.get(1);
            graph.putIfAbsent(u, new ArrayList<>());
            graph.putIfAbsent(v, new ArrayList<>());
            graph.get(u).add(new Node(v, value));
            graph.get(v).add(new Node(u, 1/value));
        }
    }

}
