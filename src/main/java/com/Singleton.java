package com;

import java.io.File;
import java.util.HashMap;
import java.util.Hashtable;

public class Singleton {

	private static Singleton s = new Singleton();
	public static Singleton getInstance(){
		return s;
	}
	
	
	public static void main(String[] args) {
//		Singleton s = Singleton.getInstance();
//		Singleton s2= Singleton.getInstance();
//		System.out.println(s == s2);
//		String f = new File("D:/android/adt-bundle-windows-x86/eclipse/artifacts.xml").separator;
//		System.out.println(f);
		
//		HashMap m = new HashMap();
//		m.put("", "");
		
//		Hashtable m2= new Hashtable();
//		m2.put("", "");
//		
//		String s = new String("abc").intern();
//		String s1= "abc";
//		System.out.println(s==s1);
//		String s2 = new String("abc");
//		String s3 = s.intern();
//		System.out.println(s1==s.intern());
//		System.out.println(s3==s2.intern());
		
		String s = "abc";
		String s1="ab"+"c";
		String s3="c";
		String s2="ab"+s3;
		
		
		System.out.println(s==s1);
		System.out.println(s==s2);
	}
}
