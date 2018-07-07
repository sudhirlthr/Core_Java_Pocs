package com.sudhir.amcat;

public class PrintNumbers {

	static int start_point = 1, count = 1;
	public static void main(String[] args) {
		printNum(10);
	}

	public static void printNum(int n) {
		for(int i=1;i<=n;i++) {
				if(i%2!=0) { // for odd lines
					printOddLines(start_point);
				}
				else { // for even lines
					rec(start_point);
				}
				count++;
			System.out.println();
		}
	}
	public static void rec(int n) {
		int temp = n;
		for(int i=1;i<count;i++)
			temp += 1;
		start_point = temp+1;
		for(int i=temp;i>=n;--i) {
			System.out.print(i);
			if(i>n)
				System.out.print("*");
		}
	}
	public static void printOddLines(int n) {
		int temp = n;
		for(int i=1;i<count;i++)
			temp += 1;
		start_point = temp+1;
		for(int i=n;i<=temp;i++) {
			System.out.print(i);
			if(i<temp)
				System.out.print("*");
		}
	}
}
