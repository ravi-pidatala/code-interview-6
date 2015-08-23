package com.chapter4;


public class TreeNode {

	private TreeNode left;
	private TreeNode right;
	private int data;	

	public TreeNode(int data) {
		this.data = data;
	}

	public TreeNode getLeft() {
		return left;
	}
	
	public void setLeft(TreeNode left) {
		this.left = left;
	}

	public TreeNode getRight() {
		return right;
	}
	
	public void setRight(TreeNode right) {
		this.right = right;
	}

	@Override
	public String toString() {
		return "" + data + "";
	}
}
