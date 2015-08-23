package com.chapter4;


public class TreeUtil {

	
	public static TreeNode constructTree() {
		TreeNode root = new TreeNode(67);
		TreeNode node1 = new TreeNode(34);
		TreeNode node2 = new TreeNode(91);
		TreeNode node3 = new TreeNode(4);
		TreeNode node4 = new TreeNode(56);
		TreeNode node5 = new TreeNode(88);
		TreeNode node6 = new TreeNode(1002);
		TreeNode node7 = new TreeNode(12200);
		
		root.setLeft(node1);
		root.setRight(node2);
		node1.setLeft(node3);
		node1.setRight(node4);
		node2.setLeft(node5);
		node2.setRight(node6);
		node6.setRight(node7);

		return root;
	}





}
