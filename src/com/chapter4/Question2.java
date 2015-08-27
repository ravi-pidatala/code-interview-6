package com.chapter4;

import java.util.LinkedList;
import java.util.Queue;

/*
	middle element in the array should be root. 
	middle element in the left subarray should be left child.
	middle element in the right subarray should be right child.
	and so on ..

	if array is of odd length , there is one middle element, else there will be two middle elements. any one of two elements can be root. In this exmple 
	we will select left one as root.
	height of tree with n elements is 1 + 2 + 4 + 8 + 16 + 32 + .. . 
	Sum of geometric progression is a[t ^n - 1] / t - 1 for a , at, at^2, a.t^3, ...a.t^(n -1)
	
	COMMENTS: could do it well but wrote lot of boilerplate code for first time . Could resolve it only after looking answer in the book . 

*/
public class Question2 {
	
	/*
		expected output: root is a[9] = 10.
		10, 5, 15, 2, 7, 12, 17, etc..
					    10
				       /  \
				      5   15
				     / \  /  \
				    2  7  12  18
			       / \ /\ /\   /\
                                  	
				    	
	*/
	public static void main(String [] args) {
		int [] a = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15, 16, 17, 18, 19, 20}; 
		Question2 q = new Question2();
		TreeNode rootNode = q.constructTree(a);
		q.printTree(rootNode);
	}

//	public TreeNode getRootNode(int [] a) {
//		if (a.length == 0) {
//			return null;
//		}
//		
//		TreeNode root = constructTree(a, 0, rightIndex, node)
//		int middleIndex = (0 + a.length - 1) / 2;
//		TreeNode root = new TreeNode(a[middleIndex]);
//		
//		//construct left
//		constructTree(a, 0, middleIndex - 1, root, true);
//
//		// construct right
//		constructTree(a, middleIndex + 1, a.length - 1, root, false); 
//		return root;
//
//	}
	
	public TreeNode constructTree(int [] a) {
		return constructTree(a, 0, a.length -1);
	}
	
	private TreeNode constructTree(int [] a, int leftIndex, int rightIndex) {
		
		// base case
		if (leftIndex > rightIndex) {
			return null;
		}	
		int middleIndex = (leftIndex + rightIndex) / 2;
		
		TreeNode nodeToInsert = new TreeNode(a[middleIndex]);

		
		// construct left side
		nodeToInsert.setLeft(constructTree(a, leftIndex, middleIndex - 1));

		//construct right side
		nodeToInsert.setRight(constructTree(a, middleIndex + 1, rightIndex));
		return nodeToInsert;
	}

	// tree printing is similar to BFS. Since this is binary tree , no need to make note if node is visited or not.
	private void printTree(TreeNode node) {
		if (node == null) {
			return;
		}
		
		Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
		nodeQueue.add(node);

		while (!nodeQueue.isEmpty()) {
			TreeNode nodeToPrint = nodeQueue.poll();			
			System.out.print(nodeToPrint + ",");
			if (nodeToPrint.getLeft() != null) {
				nodeQueue.add(nodeToPrint.getLeft());
			}

			if (nodeToPrint.getRight() != null) {
				nodeQueue.add(nodeToPrint.getRight());
			}
		}
		return;
	}
}
