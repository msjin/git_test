package com.mianShiTi;

public class Extends1 {

	public static void main(String[] args) {
		B b = new B();
		b= new B();
	}
	
}


class A{
	static{
		System.out.println("a");
	}
	
	public A(){
		System.out.println("x");
	}
}

class B extends A{
	static {
		System.out.println("b");
	}
	
	public B(){
		System.out.println("y");
	}
}


class MyClass {
static String s1;
String s2;
public static void main(String args[]) {
String s3;
System.out.println("s1 =" + s1);
//System.out.println("s2 =" + s2);
//System.out.println("s3 =" + s3);
}
}


class MyClass2 {
static void aMethod(StringBuffer sf1, StringBuffer sf2) {
sf1.append(sf2);
sf2 = sf1;
}
public static void main(String[] args){
StringBuffer sf1 = new StringBuffer("A");
StringBuffer sf2 = new StringBuffer("B");
aMethod(sf1,sf2);
System.out .println(sf1+ ":"+sf2);
}
}


class MyClass3 {
static void aMethod(String sf1, String sf2) {
 sf1+=sf2;
sf2 = sf1;
System.out.println(sf1);
}
public static void main(String[] args){
String sf1 = new String("A");
String sf2 = new String("B");
aMethod(sf1,sf2);
System.out .println(sf1+ ":"+sf2);
}
}



class Super{
int i=10;
Super(){
print();
i=20;
}
void print(){
System.out.print(i);
}
}
class Sub extends Super{
int j=30;
Sub(){
print();
j=40;
}
void print(){
System.out.print(j);
}
public static void main(String[] args){
System.out.print(new Sub().j);
}
}


class testtt{
	int i=2;
	public testtt(){
		System.out.println(i);
	}
	public static void main(String[] args) {
		new testtt();
	}
}