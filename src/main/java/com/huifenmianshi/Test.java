package com.huifenmianshi;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		byte b = 1;
//		int i=0;
//		while(++b>0) {
//			i=i+1;
//			System.out.println(i);;
//		}
//		System.out.println("welcome");
//		
//		Test t = new Test(22);
//		Q3 q= new Q3(22);
//		t=q;
//		System.out.println(t.equals(q));
		
//		Boolean[] b1= new Boolean[10];
//		boolean[] b2= new boolean[10];
//		System.out.println(b1[0]);
//		System.out.println(b2[0]);
		
//		System.out.println(i);
//		doStuff(i);
		
//		List<bb> l = new ArrayList<bb>(10);
//		System.out.println(l.size());
		
//		Test t = new Test(11);
//		String s1 = "abc"; 
//		String s2 = "def"; 
//		Vector v = new Vector(); 
//		v.add(s1); 
//		v.add(s2); 
//		String s3 = v.elementAt(0) + v.elementAt(1); 
//		System.out.println(s3); 
		
		
//		Set set = new TreeSet();
//		Integer s = new Integer(2);
//		set.add(s);
//		set.add(s);
//		set.add("1");
//		Iterator it = set.iterator();
//		while (it.hasNext())
//		System.out.print(it.next() + " ");
		
//		List<Integer> myList = new ArrayList<Integer>();
//		myList.add(4);
//		myList.add(6);
//		displayAll(myList);
		
//		List<Integer> myList = new ArrayList<Integer>();
//		myList.add(4);
//		myList.add(6);
//		int total = addAll(myList);
//		System.out.println(total);
		
//		List<Q3> list = new ArrayList<Q3>();
//		List<? extends Test> l = new ArrayList<Q3>();
//		l.add(1);
	}
	
	static void  displayAll(List list) {
		list.add("Test");
		Iterator it = list.iterator();
		while (it.hasNext()) {
			System.out.print(it.next());
		}}
	
	static int addAll(List list) {
		Iterator it = list.iterator();
		int total = 0;
		while (it.hasNext()) {
		int i = ((Integer)it.next()).intValue();
		total += i;
		}
		return total;
		}
	
	void test(){
		 List list = new ArrayList(2);
		 int i=2;
			while(list.size()>=2){
				System.out.println("Excecuting while loop:"+list.get(i));
				i++;
			}
		}
	
	static int i;
	
	static void doStuff(int z){
		int z2=50;
		System.out.println(z2+z);
	}
	
	public static void main(int[] args) {
//		Test t = new Test(11);
//		t.show();
//		Q3 q = new Q3(22);
//		q.show();
//		t=q;
//		t.show();
//		q=t;
//		q.show();
	}
	
	void show(){
		System.out.println("test show");
	}
	
	int aa;
	void Test(){
		aa=100;
		System.out.println(aa);
	}
	Test(int a){
		aa=a;
		System.out.println(aa);
	}
}

class bb{
	public bb(){
		System.out.println("bb");
	}
}

class Q3 extends Test{
	Q3(int a) {
		super(a);
	}
	

	void show(){
		System.out.println("Q3 show");
	}
	
	
}

interface intf{
	int a=1;
	abstract void tt();
	
	class A{
		private void a(){
			System.out.println("sdfsfsd");
		}
		public static void main(String[] args) {
			System.out.println("sdfsdfsdfsd");
		}
	}
}


class Outer {
	   private final int x=1;

	   private class Inner {
	      private final int y=2;
	   }
	}


//3. Choose correct statement about below

//class ExceptionA extends Exception {}
//class ExceptionB extends ExceptionA {}
//public class Test1{
//    void thrower() throws ExceptionB{
//    throw new ExceptionB();
//    }
//    public static void main(String[] args){
//     Test1 t = new Test1();
//     try{t.thrower();}
//     catch(ExceptionA e) {
//      System.out.println("Caught Exception A");
//     }
//     catch(ExceptionB e) {
//       System.out.println("Caught Exception B");
//     }
//    }
//}

//class ExceptionA extends RuntimeException {}
// class Test2{
//  void thrower() throws ExceptionA{
//	    throw new ExceptionA();
//	}
//   public static void main(String[] args){
//      Test2 t = new Test2();
//      try{
//       t.thrower();
//      }catch(ExceptionA e) {
//	     System.out.println("Caught Exception A");
//	    } } }

//class ExceptionA extends Exception {}
// class ExceptionB extends Exception {}
// class Test3{
//  void thrower() throws ExceptionA, ExceptionB{
//      try{
//	    throw new ExceptionA();
//	 }catch(Exception ex){
//	  throw new ExceptionA();
//	 }finally{
//	     throw new ExceptionB();
//  }	  }
//   public static void main(String[] args){
//      Test3 t = new Test3();
//      try{
//       t.thrower();
//      }catch(ExceptionA e) {
//	     System.out.println("Caught Exception A");
//	     }  } }

//class ExceptionA extends Exception {}
//class ExceptionB extends ExceptionA {}
//class A{
//  void thrower() throws ExceptionA{
//    throw new ExceptionA();
//   }
//}
//class B extends A{
//  void thrower() throws ExceptionB{
//     throw new ExceptionB();
// }
//}

class ThreadClassA extends Thread{
	public void run(){
		System.out.println("run");
	}
	}

	class Tes4{
	 public static void main(String[] args){
	  ThreadClassA a1= new ThreadClassA();
	  a1.start();
	  ThreadClassA a2= new ThreadClassA();
	  a2.run();
	  ThreadClassA a3= new ThreadClassA();
	  a3.run();
	 } 
	}