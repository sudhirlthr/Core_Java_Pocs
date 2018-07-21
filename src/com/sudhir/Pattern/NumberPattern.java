package com.sudhir.Pattern;

public class NumberPattern {

	static int number = 1;
	public static void main(String[] args) {
		print_pattern(10);
	}

	public static void print_pattern(int n) {
		boolean flag = true;
		for(int i=1;i<=n;i++) {
			print(i,flag);
			flag = !flag;
			System.out.println();
		}
	}
	
	public static void print(int i, boolean flag) {
		if(flag)
			for(int j=0;j<i;j++) {
				System.out.print(number++);
				if(j+1<i)
					System.out.print("*");
			}
		else {
			int num = number;
			for(int j=i+number;j>num;j--) {
				System.out.print(j-1);
				number++;
				if(j>i+1)
					System.out.print("*");
			}
		}
	}
}
