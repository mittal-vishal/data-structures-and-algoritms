package com.vishal.atlassian;

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



}
