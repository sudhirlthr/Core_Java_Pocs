package com.sudhir.linkedlist;

public class ReverseLinkedList {

	public static void main(String[] args) {
		Node node = new Node(1);
		node.next = new Node(2);
		node.next.next = new Node(3);
		node.next.next.next = new Node(4);
		node.next.next.next.next = new Node(5);
		new ReverseLinkedList().printLinkedListData(node);
		
		Node node2 = new Reverse().reverse(node);
		
		new ReverseLinkedList().printLinkedListData(node2);
		
	}

	public void printLinkedListData(Node nod){
		while(nod!=null) {
			System.out.println(nod.data);
			nod = nod.next;
		}
	}
}

class Node{
	int data;
	Node next;
	public Node(int data) {
		this.data = data;
		next = null;
	}
}
class Reverse{
	public Node reverse(Node node) {
			 Node prev = null, nextNode = null;
			 while(node!=null) {
				 nextNode = node.next;
				 node.next = prev;
				 prev = node;
				 node = nextNode;
			 }
			 node = prev;
		return node;
	}
}