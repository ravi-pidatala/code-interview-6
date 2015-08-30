package com.chapter4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Queue;

/*
	given binary tree, write algorithm to create linkedlist of all nodes at each depth. if depth of tree is D, we will have D linked lists.
*/
public class Question3 {

//	private int D = 8;	
	public static void main(String [] args) {
		Question2 q2 = new Question2();
		TreeNode root = q2.constructTree(new int [] {1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20});
		
		Question3 q3 = new Question3();
		HashMap<Integer, LinkedList<TreeNode>> nodesMap = q3.getLinkedLists(root);
		
		for (Entry<Integer, LinkedList<TreeNode>> set: nodesMap.entrySet()) {
			System.out.print(set.getKey() +" : ");
			q3.printLinkedList(set.getValue());
			System.out.println();
		}
	}
	
	private void printLinkedList(LinkedList<TreeNode> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "==>");
		}
	}
	
	public HashMap<Integer, LinkedList<TreeNode>> getLinkedLists(TreeNode root) {
		Queue<TreeNode> oldQ = new LinkedList<TreeNode>();
		Queue<TreeNode> newQ = new LinkedList<TreeNode>();
		HashMap<Integer, LinkedList<TreeNode>> nodesMap = new HashMap<Integer, LinkedList<TreeNode>>();
		
		LinkedList<TreeNode> nodeLinkedList = new LinkedList<TreeNode>();
		nodeLinkedList.add(root);
		nodesMap.put(0, nodeLinkedList);
		oldQ.add(root);
		getLinkedLists(oldQ, newQ, nodesMap, 1);
		return nodesMap;
	}
	
	/*
	BFS approach does not tell about node depth. 
	Recursive approach with depth and list as arguments should work.Assume that depth D is given.
	How to know which

	HINT: this can be done by using two queues. Got this hint after looking at previously solved problem 	
*/

	// null nodes will not be shown.
	public void getLinkedLists(Queue<TreeNode> oldQ, Queue<TreeNode> newQ, Map<Integer, LinkedList<TreeNode>> nodesMap, int depth) {
		LinkedList<TreeNode> nodeLinkedList = new LinkedList<TreeNode>();
		
		// base case.
//		if (depth > D) {
//			return;
//		}
		
		if (oldQ.isEmpty()) {
			return;
		}
			
		while (!oldQ.isEmpty()) {
			TreeNode tempNode = oldQ.poll();
			if (tempNode.getLeft() != null) {
				newQ.add(tempNode.getLeft());
				nodeLinkedList.add(tempNode.getLeft());
			}
			if (tempNode.getRight() != null) {
				 newQ.add(tempNode.getRight());
				 nodeLinkedList.add(tempNode.getRight());
			}	
		}
		nodesMap.put(depth, nodeLinkedList);
		getLinkedLists(newQ, oldQ, nodesMap, ++depth);
	}
}


