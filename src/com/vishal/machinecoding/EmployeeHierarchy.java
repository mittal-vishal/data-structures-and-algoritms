package com.vishal.machinecoding;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class EmployeeHierarchy {

    static class Data{
        Integer id;
        String address;
        String name;
        Integer managerID;
        public Data(Integer id, String address, String name, Integer managerID){
            this.id = id;
            this.address = address;
            this.name = name;
            this.managerID = managerID;
        }
    }

    private static HashMap<Integer, Integer> idNodeMap;
    private static List<List<Data>> graph;
    private static int depthResult;
    private static HashMap<Integer, Data>  nodeData;

    public static void main(String[] args) {
        Data line1 = new Data(2, "Mumbai", "Ratan Tata", null);
        Data line2 = new Data(3, "Ahemdabad", "Gautam Adani", 2);
        Data line3 = new Data(4, "Mumbai", "Mukesh Ambani", 3);
        Data line4 = new Data(5, "London", "L.N. Mittal", 2);
        Data line5 = new Data(6, "Pune", "Cyrus Poonawala", 4);
        List<Data> input = new ArrayList<>(Arrays.asList(line1, line2, line3, line4, line5));
        buildGraph(input);
        String ceo = getCEO(graph);
        System.out.println(ceo);
        //getDepth(graph.get(0));
        System.out.println(depthResult);
        System.out.println(getManager(graph));
    }

//    private static int getDepth(Data graph){
//        int depth = 0;
//        for(int i = 0; i < graph.size(); i++){
//            depth = 1 + getDepth(graph.get(i));
//            depthResult = Math.max(depthResult, depth);
//        }
//        return depth;
//    }

    private static List<String> getManager(List<List<Data>> graph){
        List<String> result = new ArrayList<>();
        for(int i = 0; i < graph.size(); i++){
            if(graph.get(i).size() > 0 && nodeData.get(i) != null){
                result.add(nodeData.get(i).name);
            }
        }
        return result;
    }

    private static void buildGraph(List<Data> input) {
        graph = new ArrayList<>();
        //<emp_id, node_id>
        idNodeMap = new HashMap<>();
        int nodeIdCounter = 1;
        nodeData = new HashMap<>();
        for(Data data: input){
            if(!idNodeMap.containsKey(data.id)){
                idNodeMap.put(data.id, nodeIdCounter++);
            }
            if(!nodeData.containsKey(data.id)){
                nodeData.put(data.id, data);
            }
        }
        for(int i = 0; i < nodeIdCounter; i++){
            graph.add(new ArrayList<>());
        }
        for(Data data: input){
            if(data.managerID == null){
                graph.get(0).add(new Data(data.id, data.address, data.name, data.managerID));
            }else{
                graph.get(data.managerID).add(new Data(data.id, data.address, data.name, data.managerID));
            }
        }
    }

    private static String getCEO(List<List<Data>> graph){
        return graph.get(0).get(0).name;
    }

}

/*
*
* 2         Ratan Tata                               Mumbai
3         Gautam Adani            2            Ahemdabad
4         Mukesh Ambani         3            Mumbai
5         L.N. Mittal                  2            London
6         Cyrus Poonawala      4            Pune

* */