package com.vishal.walmart;

import java.util.*;

public class Walmart {

    /*
    *
    * Print the iternary
    *
    * [src,dest]
    *
    * Map<Trivandrum, Delhi>
    *
    * <Trivandrum,Delhi>
    <Delhi,Mumbai>
    * <Mumbai,Kolkata>
    *
    * */

    public static void main(String[] args) {
        HashMap<String, String> graph = new HashMap<>();
        graph.put("Delhi", "Mumbai");
        graph.put("Bangalore", "Cochin");
        graph.put("Chennai", "Bangalore");
        graph.put("Trivandrum", "Delhi");
        graph.put("Mumbai", "Chennai");
        List<String> iternaries = getIternary(graph);
        System.out.println(iternaries);
    }

    public static List<String> getIternary(HashMap<String, String> graph){
        //base check
        if(graph == null || graph.size() == 0) {
            return new ArrayList<>();
        }
        //dfs traversal and prepare the iteranary
        List<String> iternaries = new ArrayList<>();
        //initially src will contain the src city of first entry in the input graph
        String src = "";
        for(Map.Entry<String, String> entry: graph.entrySet()){
            if(!graph.containsValue(entry.getKey())){
                src = entry.getKey();
                break;
            }
        }
        dfs(graph, src, iternaries);
        return iternaries;
    }

    private static void dfs(HashMap<String, String> graph, String src, List<String> iternaries){
        iternaries.add(src);
        String neighbourCity = graph.get(src);
        if(neighbourCity != null){
            dfs(graph, neighbourCity, iternaries);
        }
    }


    /*
    *
    * [A,B,C,D]
    * [1,2,5,8] 8+1+5+1+2=17
    * 2+1+8+2+2=17
    * 2+1+5+1+8
    *
    *
    * 2+1+5+2+2  [B,C,D]
    *
    *
    * PriorityQueue<Integer> minHeap
    *
    *
    * */

}
