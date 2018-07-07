package com.sudhir.tree;

public class LevelOrderTraversal {

	public static void main(String[] args) {

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
		new Level().printLevelOrder(node2);
		
	
	}

}
class Level{
	public void printLevelOrder(Node node) {
		int height = getHeight(node);
		System.out.println("Height = "+height);
		for(int i=1;i<height;i++)
			printGivenLeveNode(node, i);
	}
	
	public int getHeight(Node node) {
		if(node == null) return 1;
		else{
			int lheight = getHeight(node.left);
			int rheight = getHeight(node.right);
			return Math.max(getHeight(node.left), getHeight(node.right)) + 1;
		}
	}
	public void printGivenLeveNode(Node node, int h) {
		if(node == null) return;
		if(h==1) System.out.println("Node data = "+node.key);
		else if(h>1) {
			printGivenLeveNode(node.left,h-1);
			printGivenLeveNode(node.right, h-1);
		}
	}
}