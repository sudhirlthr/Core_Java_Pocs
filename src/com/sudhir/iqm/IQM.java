package com.sudhir.iqm;

public class IQM {
    public static String transform(String input) {
       char[] arr = input.toCharArray();
       
       String str = ""+arr[0];
       char p = arr[0];
       for(int i=1;i<arr.length;i++) {
    	   char c= arr[i];
    	   if(p!=c)
    		   str = str+""+c;
    	   
    	   p=c;
       }
       return str;
    }
    
    public static void main(String[] args) {
        System.out.println(IQM.transform("aabcbbb"));        
    }}
