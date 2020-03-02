package com.vishal.graph;

public class GraphNode {
	
	private int source;
	
	private int destination;
	
	private int cost;

	public GraphNode(int source, int destination, int cost) {
		super();
		this.source = source;
		this.destination = destination;
		this.cost = cost;
	}

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getDestination() {
		return destination;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}

	
}
