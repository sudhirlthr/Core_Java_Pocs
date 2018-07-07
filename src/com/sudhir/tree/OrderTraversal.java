package com.sudhir.tree;

public class OrderTraversal {

	public static void main(String[] args) {
		BinaryTree bt = new BinaryTree();
		Node node = new Node(1);
		node.left = new Node(2);
		node.right = new Node(3);
		node.left.left = new Node(4);
		node.left.right = new Node(5);
		System.out.println("***** InOrder***** :\n\n");
		bt.inOrderTraversal(node);
		System.out.println("***** PreOrder***** :\n\n");
		bt.preOrderTraversal(node);
		System.out.println("***** PostOrder***** :\n\n");
		bt.postOrderTraversal(node);
		
		System.out.println();
		
		Node node2 = new Node(25);
		node2.left = new Node(15);
		node2.right = new Node(50);
		node2.left.left = new Node(10);
		node2.left.right = new Node(22);
		node2.right.left = new Node(35);
		node2.right.right = new Node(70);
		
		node2.left.left.left = new Node(4);
		node2.left.left.right = new Node(12);
		
		node2.left.right.left = new Node(18);
		node2.left.right.right = new Node(24);
		node2.right.left.left = new Node(31);
		node2.right.left.right = new Node(44);
		
		node2.right.right.left = new Node(66);
		node2.right.right.right = new Node(90);
		System.out.println("***** InOrder***** :\n\n");
		bt.inOrderTraversal(node2);
		System.out.println("***** PreOrder***** :\n\n");
		bt.preOrderTraversal(node2);
		System.out.println("***** PostOrder***** :\n\n");
		bt.postOrderTraversal(node2);
	}

}
class Node{
	int key;
	Node left,right;
	public Node(int key) {
		this.key = key;
		left=right=null;
	}
}
class BinaryTree{
	Node root;
	public BinaryTree() {
		root = null;
	}

	public void inOrderTraversal(Node node) {
		if(node == null) return;
		else {
			inOrderTraversal(node.left);
			System.out.println(node.key);
			inOrderTraversal(node.right);
		}
	}
	

	public void preOrderTraversal(Node node) {
		if(node == null) return;
		else {
			System.out.println(node.key);
			preOrderTraversal(node.left);
			preOrderTraversal(node.right);
		}
	}

	

	public void postOrderTraversal(Node node) {
		if(node == null) return;
		else {
			postOrderTraversal(node.left);
			postOrderTraversal(node.right);
			System.out.println(node.key);
		}
	}


}

class Travesal{}