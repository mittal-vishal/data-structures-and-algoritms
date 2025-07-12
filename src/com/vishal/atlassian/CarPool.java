package com.vishal.atlassian;

import java.util.*;

/*
* 🚗 Problem Story
You and your friends are going camping.

Only 2 of you have cars, and you'll be carpooling others to the Campground.

Your friends live at different towns along linear roads that ultimately lead to the Campground.

Both cars leave their starting points at the same time and follow their respective routes toward the Campground.

🛣️ Road System
The roads are directed (one-way) and linear:

Each road connects a town to the next one toward the Campground.

The format of each road is: [from, to, duration in minutes].

Example:
Bridgewater --(30 min)--> Caledonia --(15 min)--> New Grafton --(5 min)--> Campground
                             ^                                      ^
                         (from Liverpool)                     (from Milton)
The entire network forms a tree or DAG (no loops or cycles).

🧑‍🤝‍🧑 People
Each friend lives in a town, represented as:

["Jessie", "Bridgewater"]
["Travis", "Caledonia"]
["Jeremy", "New Grafton"]
["Katie", "Liverpool"]
🚙 Car Rules
There are 2 cars, starting from different towns (e.g., Bridgewater and Liverpool).

How cars pick up people:
A car picks up someone if it's the first to pass through their town.

If both cars arrive at the same time, the person can choose either car.

🎯 Goal
For each friend, determine which car will pick them up based on the earliest arrival to their town.

At the end, return a list of who is in each car when they reach the Campground.

🧠 Example
roads1 = [
  ["Bridgewater", "Caledonia", "30"],
  ["Caledonia", "New Grafton", "15"],
  ["New Grafton", "Campground", "5"],
  ["Milton", "New Grafton", "30"],
  ["Liverpool", "Milton", "10"]
]

starts1 = ["Bridgewater", "Liverpool"]

people1 = [
  ["Jessie", "Bridgewater"],
  ["Travis", "Caledonia"],
  ["Jeremy", "New Grafton"],
  ["Katie", "Liverpool"]
]
Let’s simulate:

Car 1 (Bridgewater):

0 min: Bridgewater → picks up Jessie

30 min: Caledonia → picks up Travis

45 min: New Grafton

50 min: Campground

Car 2 (Liverpool):

0 min: Liverpool → picks up Katie

10 min: Milton

40 min: New Grafton → arrives before Car 1 → picks up Jeremy

45 min: Campground

✅ Final Car Assignment
Person	Town	Picked By	Why
Jessie	Bridgewater	Car 1	Car 1 starts here
Travis	Caledonia	Car 1	Car 1 reaches at 30min
Jeremy	New Grafton	Car 2	Car 2 reaches at 40min, Car 1 at 45min
Katie	Liverpool	Car 2	Car 2 starts here
* */
public class CarPool {

    static class Edge{
        String city;
        Integer dist;
        public Edge(String city, Integer dist){
            this.city = city;
            this.dist = dist;
        }
    }

    public static void main(String[] args) {
        List<String[]> roads = Arrays.asList(
                new String[]{"Bridgewater", "Caledonia", "30"},
                new String[]{"Caledonia", "New Grafton", "15"},
                new String[]{"New Grafton", "Campground", "5"},
                new String[]{"Milton", "New Grafton", "30"},
                new String[]{"Liverpool", "Milton", "10"}
        );
        List<String> starts = List.of("Bridgewater", "Liverpool");
        List<String[]> people = List.of(
                new String[]{"Jessie", "Bridgewater"},
                new String[]{"Travis", "Caledonia"},
                new String[]{"Jeremy", "New Grafton"},
                new String[]{"Katie", "Liverpool"}
        );
        List<List<String>> result = assignCarpool(roads, starts, people);
        List<String> cars1 = result.get(0);
        List<String> cars2 = result.get(1);
        System.out.println("Car 1:" + cars1);
        System.out.println("Car 2:" + cars2);
    }

    private static List<List<String>> assignCarpool(List<String[]> roads, List<String> starts, List<String[]> people) {
        HashMap<String,List<Edge>> graph = new HashMap<>();
        for(String[] road: roads){
            String src = road[0];
            String dest = road[1];
            Integer dist = Integer.valueOf(road[2]);
            graph.putIfAbsent(src, new ArrayList<>());
            graph.get(src).add(new Edge(dest, dist));
        }
        HashMap<String,Integer> cars1Time = getArrivalTime(starts.get(0), graph);
        HashMap<String,Integer> cars2Time = getArrivalTime(starts.get(1), graph);
        List<String> cars1 = new ArrayList<>();
        List<String> cars2 = new ArrayList<>();
        for(String[] peopleCity: people){
            String peopleName = peopleCity[0];
            String city = peopleCity[1];
            Integer t1 = cars1Time.getOrDefault(city, Integer.MAX_VALUE);
            Integer t2 = cars2Time.getOrDefault(city, Integer.MAX_VALUE);
            if(t1 < t2){
                cars1.add(peopleName);
            }else{
                cars2.add(peopleName);
            }
        }
        return List.of(cars1, cars2);
    }

    private static HashMap<String, Integer> getArrivalTime(String city, HashMap<String, List<Edge>> graph) {
        HashMap<String,Integer> cityTime = new HashMap<>();
        Queue<String> queue = new LinkedList<>();
        queue.offer(city);
        cityTime.put(city, 0);
        while(!queue.isEmpty()){
            String currCity = queue.poll();
            Integer currCityTime = cityTime.get(currCity);
            for(Edge neighbor: graph.getOrDefault(currCity, new ArrayList<>())){
                Integer newTime = currCityTime + neighbor.dist;
                if(!cityTime.containsKey(neighbor.city) || cityTime.get(neighbor.city) > newTime){
                    cityTime.put(neighbor.city, newTime);
                    queue.offer(neighbor.city);
                }
            }
        }
        return cityTime;
    }
}
