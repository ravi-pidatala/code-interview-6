package com.chapter4;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

/*
	Design algorithm to print linkedlist of all nodes at each depth. If you have a tree with depth D, you will have D linked lists. 
	
	Tree --
				6           left = 0, right = 12;
			 /	  \
		   2        9
		 /	\      /  \
		 0    4   7    11
  		  \  /\    \    /\
	      1 3  5    8 10  12 
	      
	  Expected Result:
	  0: 6
	  1: 2 ==> 9
	  2: 0 ==> 4 ==> 7 ==> 11
	  3: 1 ==> 3 ==> 5 ==> 8 ==> 10 ==> 12
	  
	  NOTES:
	  1. ArrayList can be used instead of hashmap if the keys are expected to be in order.
	  
	  
	  
*/
	public class Question3v2 {
		public static void main(String [] args) {
			Question2 q2 = new Question2();
			TreeNode root = q2.constructTree(new int [] {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12});
		
			Question3v2 q3 = new Question3v2();
		
			Map<Integer, LinkedList<TreeNode>> nodeMap = q3.getLinkedListMap(root);
		
			for (int i = 0; i < nodeMap.size(); i++) {
				q3.printLinkedList(nodeMap.get(i));
				System.out.println();
			}
		
			List<LinkedList<TreeNode>> nodeLinkedLists = q3.getLinkedLists(root);
			
			for (LinkedList<TreeNode> nodeLinkedList: nodeLinkedLists) {
				q3.printLinkedList(nodeLinkedList);
				System.out.println();
			}
	}
		


	private void printLinkedList(LinkedList<TreeNode> list) {
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + "==>");
		}
	}

	public Map<Integer, LinkedList<TreeNode>> getLinkedListMap(TreeNode node) {
		Map<Integer, LinkedList<TreeNode>> nodeMap = new HashMap<Integer, LinkedList<TreeNode>>();
		getLinkedListMap(node, nodeMap, 0);
		return nodeMap;
	}

	/*
	PreOrder traversal noting depth of Node from root.
	*/
	private void getLinkedListMap(TreeNode node, Map<Integer, LinkedList<TreeNode>> nodeMap, int depth) {
		if (node == null) {
			return;				
		}
		
		// add current node to linkedList.
		LinkedList<TreeNode> nodeList = nodeMap.get(depth);

		if (nodeList == null) {
			nodeList = new LinkedList<TreeNode>();
			nodeMap.put(depth, nodeList);
		}
		nodeList.add(node);
		
		// process left side child
		getLinkedListMap(node.getLeft(), nodeMap, depth + 1);
		
		// process right child
		getLinkedListMap(node.getRight(), nodeMap, depth + 1);
		
	}
	
	private void getLinkedLists(TreeNode node, List<LinkedList<TreeNode>> nodeLists, int depth) {
		if (node == null) {
			return;
		}

		LinkedList<TreeNode> nodeLinkedList = null;
		
		if (nodeLists.size() == depth) {
			nodeLinkedList = new LinkedList<TreeNode>();
			nodeLists.add(nodeLinkedList);
		} else {
			nodeLinkedList = nodeLists.get(depth);
		}

		nodeLinkedList.add(node);

		getLinkedLists(node.getLeft(), nodeLists, depth + 1);
		getLinkedLists(node.getRight(), nodeLists, depth + 1);

	}

	public List<LinkedList<TreeNode>> getLinkedLists(TreeNode root) {
		if (root == null) {
			return null;
		}

		List<LinkedList<TreeNode>> nodeLists = new ArrayList<LinkedList<TreeNode>>();
		
		getLinkedLists(root, nodeLists, 0);
		return nodeLists;
	}
		
}
