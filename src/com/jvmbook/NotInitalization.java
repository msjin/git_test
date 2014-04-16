package com.jvmbook;

public class NotInitalization {

	static boolean b ;
	
	public static void main(String[] args) {
//		System.out.println(ConstClass.HELLOWORlD);
		ConstClass[] c = new ConstClass[10];
		System.out.println(c.getClass());
		ConstClass cc = new ConstClass();
		System.out.println(cc.getClass());
		
		
		System.out.println(b);
	}
}
