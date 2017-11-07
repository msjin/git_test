package com;


public class TestJavap extends Thread {
	
	public static void main(String[] args) {
//		i=i++;
//		System.out.println(i);
		
		String str = null;
		String b = str;
		str = "b";
		System.out.println(b);
		
	}
	
	public void string1(){
		String s = "";
		s = s + "a";
		s = s + "b";
	}
	public void string2(){
		StringBuffer s = new StringBuffer();
		s.append("a");
		s.append("b");
	}
	
}
