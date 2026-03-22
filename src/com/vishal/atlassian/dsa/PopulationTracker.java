package com.vishal.atlassian.dsa;

import java.util.*;

/*
* You are tasked with designing a system that tracks population changes across various identifiers (e.g., cities, countries, users). The system must support three types of operations:

+1 <ID>: Increase the population count associated with the given ID by 1.

-1 <ID>: Decrease the population count associated with the given ID by 1.

topK <K>: Return a list of the top K IDs with the highest population counts.
* */
public class PopulationTracker {

    private HashMap<String,Integer> population;

    public PopulationTracker(){
        population = new HashMap<>();
    }

    public void increment(String id){
        population.put(id, population.getOrDefault(id, 0) + 1);
    }

    public void decrement(String id){
        population.put(id, population.getOrDefault(id, 0) - 1);
    }

    private List<Map.Entry<String,Integer>> getTopKHighestCount(int k){
        PriorityQueue<Map.Entry<String,Integer>> minHeap = new PriorityQueue<>((a,b) -> a.getValue() - b.getValue());
        for(Map.Entry<String,Integer> entry: population.entrySet()){
            minHeap.offer(entry);
            if(minHeap.size() > k){
                minHeap.poll();
            }
        }
        List<Map.Entry<String,Integer>> results = new ArrayList<>(minHeap);
        Collections.reverse(results);
        return results;
    }

    public static void main(String[] args) {
        PopulationTracker tracker = new PopulationTracker();
        tracker.increment("A");
        tracker.increment("B");
        tracker.increment("C");
        tracker.increment("A");
        tracker.increment("B");
        tracker.increment("A");
        tracker.decrement("C");
        List<Map.Entry<String,Integer>> topK = tracker.getTopKHighestCount(2);
        for(Map.Entry<String,Integer> entry: topK){
            System.out.println("Id=" + entry.getKey() + ", value="+ entry.getValue());
        }
    }

}
