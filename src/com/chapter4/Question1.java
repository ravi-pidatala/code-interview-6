package com.chapter4;

import java.util.LinkedList;
import java.util.Queue;

/*
	finding whether there is a route between two nodes. i.e. if BFS yeilds result, there is route , else there is no route. 
	BFS requires Queue
*/
public class Question1 {
	
	public static  void main(String [] args) {
		Question1 q = new Question1();
		GraphNode root = GraphUtil.constructGraph();		
		GraphNode node2 = new GraphNode("6");
		System.out.println("Is route present between " + root + " and " + node2 + "? :" + q.hasRoute(root, node2));
		
		root = GraphUtil.constructGraph();
		node2 = new GraphNode("5");
		 System.out.println("Is route present between " + root + " and " + node2 + "? :" + q.hasRoute(root, node2));
	}

	private boolean hasRoute(GraphNode node1, GraphNode node2) {
		//null check
		if (node1 == null || node2 == null) {
			return false;
		}

		if (breadthFirstSearch(node1, node2.getData()) != null) {
			return true;
		}
		return false;
	}

	private GraphNode breadthFirstSearch(GraphNode node, String data) {
		// null check
		if (node == null) {
			return null;
		}
		
		Queue<GraphNode> nodesQueue = new LinkedList<>();
		nodesQueue.add(node);
		node.setVisited(true);

		while (!nodesQueue.isEmpty()) {
			GraphNode searchNode = nodesQueue.poll();

			if (searchNode == null) {
				continue;
			}
			System.out.println("searching" + searchNode);
			
			if (searchNode.getData() != null && searchNode.getData().equals(data)) {
				return searchNode;
			}
		
			if (searchNode.getAdjNodes() != null) {
				for (GraphNode graphNode: searchNode.getAdjNodes()) {
					if (graphNode == null || graphNode.isVisited()) {
						continue;
					}
					nodesQueue.add(graphNode);
					graphNode.setVisited(true);
				}
			}
		}
		return null;
	}
}
