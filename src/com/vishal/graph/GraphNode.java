package com.vishal.graph;

public class GraphNode {

	private int node;

	private int cost;

	public GraphNode(int node, int cost) {
		super();
		this.node = node;
		this.cost = cost;
	}

	public int getNode() {
		return node;
	}

	public void setNode(int node) {
		this.node = node;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

}
