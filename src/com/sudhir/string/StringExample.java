/**
 * 
 */
package com.sudhir.string;

/**
 * @author sudhir
 *
 */
public class StringExample {

	public static void main(String[] args) {
		String a = "Hello";
		String b = "World";
		String c = "HelloWorld";
		String add = a+b;
		String add2 = "Hello"+"World";
		System.out.println("a = "+a.hashCode()+" and b = "+b.hashCode()+" and c = "+c.hashCode());
		System.out.println("add = "+add.hashCode()+" and add2 = "+add2.hashCode());
		
		a = a+b;
		System.out.println("a after changes = "+a+" and hashcode"+a.hashCode());
		System.out.println("a = "+a.hashCode()+" and b = "+b.hashCode()+" and c = "+c.hashCode());
		System.out.println("add = "+add.hashCode()+" and add2 = "+add2.hashCode());
		if(a==c)
			System.out.println("a=a+b=c and hashcode= "+a.hashCode());
		if(a==add)
			System.out.println("a = add and hashcode = "+a.hashCode());
		if(add==new String(a+b))
			System.out.println("add=a+b  and hashcode = "+add.hashCode());
	}

}
