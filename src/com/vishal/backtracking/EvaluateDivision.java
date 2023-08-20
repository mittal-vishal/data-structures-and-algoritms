package com.vishal.backtracking;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

public class EvaluateDivision {

    static class Node{
        String name;
        double value;
        public Node(String name, double value){
            this.name = name;
            this.value = value;
        }
    }
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        HashMap<String, List<Node>> graph = new HashMap<>();
        buildGraph(equations, values, graph);
        double[] result = new double[queries.size()];
        HashSet<String> visited = new HashSet<>();
        for(int i = 0; i < queries.size(); i++){
            String src = queries.get(i).get(0);
            String dest = queries.get(i).get(1);
            result[i] = backtrack(src, dest, values, graph, visited);
        }
        return result;
    }

    private double backtrack(String src, String dest, double[] values, HashMap<String, List<Node>> graph, HashSet<String> visited){
        if(!graph.containsKey(src) || visited.contains(src)){
            return -1d;
        }else if(src.equals(dest)){
            return 1d;
        }
        visited.add(src);
        for(Node neighbour: graph.get(src)){
            if(!visited.contains(neighbour.name)){
                double ans = backtrack(neighbour.name, dest, values, graph, visited);
                if(ans != -1d){
                    visited.remove(src);
                    return ans * neighbour.value;
                }
            }
        }
        visited.remove(src);
        return -1d;
    }

    private void buildGraph(List<List<String>> equations, double[] values, HashMap<String, List<Node>> graph){
        for(int i = 0; i < equations.size(); i++){
            String src = equations.get(i).get(0);
            String dest = equations.get(i).get(1);
            double value = values[i];
            graph.putIfAbsent(src, new ArrayList<>());
            graph.putIfAbsent(dest, new ArrayList<>());
            graph.get(src).add(new Node(dest, value));
            graph.get(dest).add(new Node(src, 1/value));
        }
    }

}
