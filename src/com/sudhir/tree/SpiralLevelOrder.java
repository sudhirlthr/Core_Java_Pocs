package com.sudhir.tree;

public class SpiralLevelOrder {

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
		new SpiralLevelOrderTraversal().printSpiral(node2);
	}

}

class SpiralLevelOrderTraversal{
	public void printSpiral(Node node){
		int height = getHeight(node);
		boolean ltr = false;
		for(int i=1;i<height;i++) {
			printGivenLevel(node, i, ltr);
			ltr = !ltr;
		}
	}
	
	public void printGivenLevel(Node node, int height, boolean ltr) {
		if(node == null) return;
		
		if(height == 1)
			System.out.println("Node data : "+node.key);
		else if(height>1){
			if(ltr) {
				printGivenLevel(node.right, height-1, ltr);
				printGivenLevel(node.left, height-1, ltr);
			}
			else {
				printGivenLevel(node.left, height-1, ltr);
				printGivenLevel(node.right, height-1, ltr);
			}
		}
	}
	
	public int getHeight(Node node) {
		if(node == null) return 1;
		else {
			return Math.max(getHeight(node.left), getHeight(node.right))+1;
		}
	}
}