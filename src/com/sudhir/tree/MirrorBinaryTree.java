package com.sudhir.tree;

public class MirrorBinaryTree {
	public static void main(String[] args) {
		TreeNode node = new TreeNode(25);
		node.left = new TreeNode(15);
		node.right = new TreeNode(50);
		node.left.left = new TreeNode(10);
		node.left.right = new TreeNode(22);
		node.right.left = new TreeNode(35);
		node.right.right = new TreeNode(70);
		
		/*node.left.left.left = new TreeNode(4);
		node.left.left.right = new TreeNode(12);
		
		node.left.right.left = new TreeNode(18);
		node.left.right.right = new TreeNode(24);
		node.right.left.left = new TreeNode(31);
		node.right.left.right = new TreeNode(44);
		
		node.right.right.left = new TreeNode(66);
		node.right.right.right = new TreeNode(90);*/
		
		printInorder(node);
		
		node = mirror(node);
		
		printInorder(node);
	}
	public static void printInorder(TreeNode node) {
		if(node == null) return;
		else {
			printInorder(node.left);
			System.out.println("Node Data = "+node.data);
			printInorder(node.right);
		}
	} 
	public static TreeNode mirror(TreeNode root) {
		if(root == null) return root;
		else {
			TreeNode left = mirror(root.left);
			TreeNode right = mirror(root.right);
			
			root.left = right;
			root.right = left;
			return root;
		}
	}
}
class TreeNode{
	int data;
	TreeNode left,right;
	TreeNode(int data){
		this.data = data;
		left = right = null;
	}
}