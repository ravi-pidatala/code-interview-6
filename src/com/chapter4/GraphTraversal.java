package com.chapter4;

import java.util.LinkedList;
import java.util.Queue;

public class GraphTraversal {
	
	public static void main(String [] args) {
		GraphNode root = GraphUtil.constructGraph();
		GraphTraversal traversal = new GraphTraversal();
		traversal.depthFirstSearch("6", root); // 0, 1, 3 ,2, 4, 5, 
	
			
		root = GraphUtil.constructGraph();
		traversal.breadthFirstSearch("7", root); // 0,1, 4, 5, 3, 2 
	}

	 private GraphNode depthFirstSearch(String data, GraphNode node) {
		GraphNode result = null;
		if (node == null) {
			return null;
		}
		 System.out.println("searching node " + node);
		if (data.equals(node.getData())) {
			return node;
		}
		node.setVisited(true);
		
		if (node.getAdjNodes() == null) {
			return null;
		}
		for (GraphNode adjNode: node.getAdjNodes()) {
			if (!adjNode.isVisited()) {
				result = depthFirstSearch(data, adjNode);
				if (result != null) {
					return result;
				}
			}
		}
		return result;
	}

	// this involves queue
	private GraphNode breadthFirstSearch(String data, GraphNode node) {
		Queue<GraphNode> nodeQueue = new LinkedList<GraphNode>();
		if(node == null) {
			return null;
		}
		nodeQueue.add(node);
		node.setVisited(true);
		
		while (!nodeQueue.isEmpty()) {
			GraphNode searchNode = nodeQueue.poll();
			
			System.out.println("searching node " + searchNode);
			if (searchNode == null || searchNode.getAdjNodes() == null) {
				continue;
			}
			
			if (searchNode.getData() != null && searchNode.getData().equals(data)) {
				return searchNode;
			}
			
			for(GraphNode graphNode: searchNode.getAdjNodes()) {
				if (!graphNode.isVisited()) {
					graphNode.setVisited(true);
					nodeQueue.add(graphNode);
				}
			}
		}
		System.out.println(data + " not found in graph");
		return null;
	}
}
