package com.mianShiTi;

import java.util.ArrayList;

import javax.lang.model.element.VariableElement;

public class Son extends Father {

	public void Father(int a){
		System.out.println("son-->father");
	}
	public Son(){
		System.out.println("son");
	}
	
	public static void main(String[] args) {
//		Father f = new Father(2);
		Short s = 5;
//		s+=(short)1;\
		int i=5;
		int c = i>>1;
		System.out.println(c);
	}
	
	ArrayList list = new ArrayList();
	public ArrayList getArrayList(){
		return (ArrayList) list.clone();
	}
	
	public void showNum(String s){
		
	}
}
