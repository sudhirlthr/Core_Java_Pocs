package com.sudhir.amcat;

public class CheckSubstringTest {

	public static void main(String[] args) {
		String Parent = "abcabcAbcAbc";
		String child = "AbcabcAbc";
		Parent = Parent.toLowerCase();
		child = child.toLowerCase();
		int index = Parent.indexOf(child), count = 0;
		if(index>=0) {
			for(int i=index;i<Parent.length();i++) {
				String str = Parent.substring(i, Parent.length()-1);
				if(str.contains(child))
						count++;
			}
		}
		
		System.out.println(count);
	}

}
