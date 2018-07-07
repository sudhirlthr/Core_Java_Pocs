/**
 * 
 */
package com.sudhir.parent_child;

/**
 * @author sudhir
 *
 */
public class ParentChild extends Parent implements Example{
	public static void main(String[] args) {
		Parent pr = new ParentChild();
		pr.getMessage();
	}
	
	public void getMessage() {
		System.out.println("In Child getMessage method");
	}

}
class Parent{
	public void getMessage() {
		System.out.println("In Parent getMessage method ");
	}
}
interface Example{
	public void getMessage();
}
