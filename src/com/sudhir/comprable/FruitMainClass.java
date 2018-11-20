package com.sudhir.comprable;

import java.util.Arrays;
import java.util.Comparator;

public class FruitMainClass {

	public static void main(String[] args) {
		Fruit[] fruits = new Fruit[4];
		Fruit fruit = new Fruit(10, "Apple", 80);
		Fruit fruit2 = new Fruit(5, "Mango", 40);
		Fruit fruit3 = new Fruit(25, "Grapes", 120);
		Fruit fruit4 = new Fruit(11, "Pomogranade", 400);
		fruits[0] = fruit;
		fruits[1] = fruit2;
		fruits[2] = fruit3;
		fruits[3] = fruit4;
		
		
		Fruit[] fruits2 = new Fruit[4];
		fruits2[0] = fruit;
		fruits2[1] = fruit2;
		fruits2[2] = fruit3;
		fruits2[3] = fruit4;
		
		System.out.println("With Comparable :\n\n"+Arrays.toString(fruits));
		Arrays.sort(fruits);
		System.out.println(Arrays.toString(fruits));
		
		System.out.println("Before sorting with name :  \n\n"+Arrays.toString(fruits2));
		
		Arrays.sort(fruits2, Fruit.FruitNameSort);
		
		System.out.println("After sorting with name :  \n\n"+Arrays.toString(fruits2));
	}

}
 class Fruit implements Comparable<Fruit>{
	 int quantity;
	 String fruitName;
	 double price;
	public Fruit(int quantity, String fruitName, double price) {
		this.quantity = quantity;
		this.fruitName = fruitName;
		this.price = price;
	}
	 
	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getFruitName() {
		return fruitName;
	}

	public void setFruitName(String fruitName) {
		this.fruitName = fruitName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int compareTo(Fruit fruit) {
		int compareQuantity = fruit.getQuantity();
		// for ascending order
		return this.quantity - compareQuantity;
	}

	@Override
	public String toString() {
		return "Fruit [quantity=" + quantity + ", fruitName=" + fruitName + ", price=" + price + "]";
	}
	
	
	// implement comparator
	public static Comparator<Fruit> FruitNameSort = new Comparator<Fruit>() {
		
		@Override
		public int compare(Fruit o1, Fruit o2) {
			return o1.getFruitName().compareTo(o2.getFruitName());
		}
	};
 }