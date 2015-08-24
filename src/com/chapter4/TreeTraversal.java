package com.chapter4;

public class TreeTraversal {
   
	public static void main(String [] args) {
		TreeTraversal traversal = new TreeTraversal();
	   	TreeNode node = TreeUtil.constructTree();
		
	   	traversal.inOrderTraversal(node);
		System.out.println();
		traversal.preOrderTraversal(node);
		System.out.println();
		traversal.postOrderTraversal(node);
	}
	
	//inorder -- left, current, right
	void inOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		inOrderTraversal(node.getLeft());
		visit(node);
		inOrderTraversal(node.getRight());	
	}

	//pre order -- current , left, right i.e. visit current node before children
	void preOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}
		visit(node);
		preOrderTraversal(node.getLeft());
		preOrderTraversal(node.getRight());
	}

	//post order -- left, right, current i.e. visit current node after children.
	void postOrderTraversal(TreeNode node) {
		if (node == null) {
			return;
		}		
		postOrderTraversal(node.getLeft());
		postOrderTraversal(node.getRight());
		visit(node);
	}
		
	void visit(TreeNode node) {
		System.out.print(node + ", ");
	}
}
