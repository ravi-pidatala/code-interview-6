package com.chapter4;


public class GraphUtil {
	
	static GraphNode constructGraph() {
		GraphNode rootNode = new GraphNode("0");
		GraphNode node1 = new GraphNode("1");
		GraphNode node2 = new GraphNode("2");
		GraphNode node3 = new GraphNode("3");
		GraphNode node4 = new GraphNode("4");
		GraphNode node5 = new GraphNode("5");

		rootNode.setAdjNodes(new GraphNode [] {node1, node4, node5});
		node1.setAdjNodes(new GraphNode[] {node3, node4});
		node2.setAdjNodes(new GraphNode[] {node1});
		node3.setAdjNodes(new GraphNode[] {node2, node4});
		
		return rootNode;	
	}


}
