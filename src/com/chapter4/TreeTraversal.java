package com.chapter4;

public class TreeTraversal {
   
	public static void main(String [] args) {
	   
		



	}
	
	//inorder -- left, current, right
	void inOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.left);
		visit(node);
		inOrderTraversal(node.right);	
	}

	//pre order -- current , left, right i.e. visit current node before children
	void preOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		visit(node);
		preOrderTraversal(node.left);
		preOrderTraversal(node.right);
	}

	//post order -- left, right, current i.e. visit current node after children.
	void postOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}		
		postOrderTraversal(node.left);
		postOrderTraversal(node.right);
		visit(node);
	}
		
	void visit(TreeNode node) {
		System.out.print(node + ", ");
	}

}
