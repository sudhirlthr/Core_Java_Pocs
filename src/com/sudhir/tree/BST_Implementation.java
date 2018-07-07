/**
 * 
 */
package com.sudhir.tree;

/**
 * @author sudhir
 *
 */
public class BST_Implementation{
	

	public static void main(String[] args) {
		BST tree = new BST();
		tree.insert(50);
		tree.insert(30);
		tree.insert(20);
		tree.insert(40);
		tree.insert(70);
		tree.insert(60);
		tree.insert(80);
		
		tree.inorder();
		
		//tree.modifyBST(tree.root);
		tree.modify(tree.root, new Sum());
		System.out.println("After modify");
		tree.inorder();
	}

	

}
class BST implements BST_Interface{
	Node root;

	public BST() {
		this.root = null;
	}
	@Override
	public void insert(int data) {
		this.root = this.insertNode(this.root, data);
	}

	@Override
	public Node insertNode(Node node, int data) {
		// If node is first node
		if(node == null) {
			this.root = new Node(data);
			return this.root;
		}
		// else put data into their proper position
		if(data < node.key)
			node.left = this.insertNode(node.left, data);
		else
			node.right = this.insertNode(node.right, data);
		return node;
	}
	@Override
	public void inorder() {
		InorderTraversal(this.root);
	}
	
	public void InorderTraversal(Node root) {
		if(root == null) return;
		InorderTraversal(root.left);
		System.out.println(" Data value : "+root.key);
		InorderTraversal(root.right);
	}
	
	/*public void modifyBST(Node root) {
		Sum sum = new Sum();
		this.modify(root, sum);
		this.modify(root);
	}*/
	/*public void modify(Node root, Sum sum) {
		if(root == null) return;
		
		// move to right node of tree
		modify(root.right, sum);
		sum.sum += root.key;
		root.key = sum.sum;
		
		// now go back to left node
		modify(root.left, sum);
	}*/
	
	public void modify(Node root, Sum sum) {
		if(root == null) return;
		
		// move to right node of tree
		modify(root.right, sum);
		sum.sum += root.key;
		root.key = sum.sum;
		
		// now go back to left node
		modify(root.left, sum);
	}
}
class Sum{
	int sum = 0;
}
