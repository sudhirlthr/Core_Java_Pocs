/**
 * 
 */
package com.sudhir.parent_child;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sudhir
 *
 */
public class PrintParentAndChild {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// a->b->c->f->->g->h, d->f->g->h
		// a->k
		String[] parent = { "a", "c", "f", "g", "", "d", "b", "d", "" };// parent nodes
		String[] child = { "b", "f", "g", "h", "a", "f", "c", "f", "d" };// child nodes

		List<String> headList = new ArrayList<>();// to keep all head node who  have child 
		for (int i = 0; i < parent.length; i++)
			if (parent[i].equals(""))
				headList.add(child[i]);// adding all nodes who are root/head node

		LinkedList[] headArray = new LinkedList[headList.size()];// array to save their child node on every root node
		int index = 0;
		for (String str : headList) {
			LinkedList head = new LinkedList(str);
			headArray[index++] = head;
		}

		for (LinkedList linkedlist : headArray) {// iterating over root/head array
			LinkedList oldNode = linkedlist;// to keep all unmodified array and added child over each child if node have child
			String currentHeadName = ""; // last node name so that it will be available to compare on parent array and then get the child 
			LinkedList currentNode = null;

			for (int j = 0; j < parent.length; j++) {// To iterate over all nodes of parent array
				while (linkedlist != null) {
					currentHeadName = linkedlist.name; // get current node and in final iteration get last node name
					currentNode = linkedlist; // node so that we can add a child if parent is there
					linkedlist = linkedlist.linkedList;// to get next node until last node
				}

				for (int i = 0; i < parent.length; i++) {// iterate over parent array to find last node has parent or not
					if (currentHeadName.equals(parent[i])) {// if node is not head then proceed
						LinkedList newNode = new LinkedList(child[i]);// since above condition is passed so create child of name/value
						currentNode.linkedList = newNode; // add created new as a child node
						linkedlist = currentNode;// to keep track all nodes from root to child
						// oldNode.linkedList = linkedlist;
					}
				}
			}
			while (oldNode.linkedList != null) {// just to print all nodes from root to leaf
				if(oldNode.name != null && !oldNode.name.equals(""))
					System.out.print(oldNode.name + " -> ");
				else
					System.out.print(oldNode.name);
				oldNode = oldNode.linkedList;
			}
			System.out.println();
		}

	}

}

class LinkedList {
	String name;
	LinkedList linkedList;

	public LinkedList(String name) {
		this.name = name;
		this.linkedList = null;
	}

}