package com.sudhir.sorocco;

public class COntinousNumbers {
	public static void main(String[] args) {
		System.out.println(printnum());
		
	}
	public static String printnum() {

		int[] array = {12,13,15,16,17};	
		int count = 0;
		
		StringBuilder sb = new StringBuilder("");
		if(array.length>2) {
			for(int i=0;i<array.length-1;i++) {
				boolean flag = true;
				if(count == 0) {
					sb.append(String.valueOf(array[i]));
					flag = false;
				}
				if(array[i]+1==array[i+1]) {
					count++;
				}
				else {
					if(count>=2)
						sb.append("-"+String.valueOf(array[i]));
					else if(flag)
						sb.append(","+String.valueOf(array[i]));
					count = 0;
					if(i!=array.length-1)
						sb.append(",");
				}
				if(count<2 && i==array.length-2 && array[i]+1==array[i+1])
					sb.append(","+String.valueOf(array[i+1]));
				else if(count<2 && i==array.length-2 && array[i]+1!=array[i+1])
					sb.append(String.valueOf(array[i+1]));
				else if(count>=2 && i==array.length-2 && array[i]+1==array[i+1])
					sb.append("-"+String.valueOf(array[i+1]));
			}
		}
		if(sb.length()<3)
			for(int i=0;i<array.length;i++)
				if(i<array.length-1)
					sb.append(array[i]+",");
				else
					sb.append(array[i]);
		
	return sb.toString();
	}
}
