package com;  

public class MemoryThread extends Thread{

	static int i = 10;
	public static void main(String[] args) {
		MemoryThread m = new MemoryThread();
		m.i= 9;
		MemoryThread m1 = new MemoryThread();
		m1.i= 8;
		Thread e = new Thread(m);
		e.start();
	}
	
	@Override
	public void run() {
		System.out.println(i);
	}
}

class MemoreThread2 implements Runnable{

	static int i = 7;
	public static void main(String[] args) {
		
		for(int i = 0;i<5;i++){
			Thread t = new Thread(new MemoreThread2());
			t.start();
		}
		MemoreThread2 m2 = new MemoreThread2();
		m2.i  = 888;
		System.out.println(m2.i);
		i = 999;
	}
	@Override
	public void run() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e) {
			e.printStackTrace();  
		}
		System.out.println(i);  
		
	}
	
}
  
