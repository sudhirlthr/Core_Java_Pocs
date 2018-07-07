/**
 * 
 */
package com.sudhir.hashmap_contract;

import java.util.HashMap;
import java.util.Map;

/**
 * @author sudhir
 *
 */
public class HashCodeAndEqualsContract {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		Apple a1 = new Apple("green",10);
		Apple a2 = new Apple("white",20);
		Map<Apple, Integer> map = new HashMap<>();
		map.put(a1, 10);
		map.put(a2, 20);
		
		System.out.println(map.get(new Apple("green",10)));
	}

}


class Apple{
	String color;
	int id;

	public Apple(String color,int id) {
		this.color = color;
		this.id = id;
	}
	
	public boolean equals(Object obj) {
		if(obj == null) return false;
		else if(!(obj instanceof Apple)) return false;
		else if(obj == this) return true;
		else
			return this.color.equals(((Apple)obj).color);
	}
	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return this.id;
	}
}
