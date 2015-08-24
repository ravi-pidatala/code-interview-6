package com.chapter4;

public class GraphNode {
	
	private String data;
	private boolean visited;	
	private GraphNode[] adjNodes;
	
	public GraphNode(String data) {
		this.data = data;
	}
	
	public String getData() {
		return data;
	}
	public void setData(String data) {
		this.data = data;
	}
	
	public boolean isVisited() {
		return visited;
	}

	public void setVisited(boolean visited) {
		this.visited = visited;
	}

	public GraphNode[] getAdjNodes() {
		return adjNodes;
	}

	public void setAdjNodes(GraphNode [] adjNodes) {
		this.adjNodes = adjNodes;
	}

	@Override
	public String toString() {
		return data;
	}
}
