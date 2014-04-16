package com.mianShiTi;

import java.lang.reflect.Method;

public class ClassForName {

	/**
	 * Class.forName（String className）这个方法的作用
	 * 
	 * 通过类的全名获得该类的类对象
	 */
	
	
	public static void main(String[] args) throws ClassNotFoundException {
		Class c = Class.forName("com.mianShiTi.ClassForName");
		Method[] m = c.getMethods();
		System.out.println(m.length>0?m[0]:m[1]);
		
	}

}
