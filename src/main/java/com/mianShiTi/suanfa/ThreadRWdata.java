package com.mianShiTi.suanfa;

import java.util.Random;

/**
 * 线程A向队列Q中不停写入数据，线程B从队列Q中不停读取数据（只要Q中有数据）。
 * 
 * @author Administrator
 * 
 * 要弄明白synchronized wait notifyAll/notify 使用
 * synchronized(obj)或者 synchronized method 锁住对象
 * wait把当前线程进入等待状态，并释放锁
 * notifyAll/notify 唤醒在此对象监视器上等待的所有线程/单个线程
 */

public class ThreadRWdata {

	public static void main(String[] args) {
		StackInterface s = new SafeStack();
		Thread puhThread = new Thread(new PuhThread(s));
		Thread popThread = new Thread(new PopThread(s));

		puhThread.start();
		popThread.start();
	}

}

// 接口中有两个一个是向队列中写push方法 一个是从队列中读。
interface StackInterface {
	public void push(int n);

	public int[] pop();
}

class SafeStack implements StackInterface {
	private int top = 0;
	private int[] values = new int[10];
	private boolean dataAvailable = false;

	public void push(int n) {
		synchronized (this) {
			while(dataAvailable){
				try {
					wait();
				} catch (InterruptedException e) {
				}
			}

			values[top] = n;
			System.out.println("压入数字：" + n + " 步骤1完成");
			top++;
			dataAvailable = true;
			this.notifyAll();
			System.out.println("压入数字完成");
		}
	}

	public int[] pop() {
		synchronized (this) {
			while (!dataAvailable) {
				try {
					wait();
				} catch (InterruptedException e) {
				}
			}

			System.out.println("弹出一个");
			top--;
			int[] test = { values[top], top };
			dataAvailable = false;
			this.notifyAll();
			return test;
		}
	}
}


class SafeStack1 implements StackInterface {
	private int top = 0;
	private int[] values = new int[10];
	private boolean dataAvailable = false;

	public void push(int n) {
		synchronized (this) {
			while (dataAvailable) // 1
			{
				try {
					wait();
				} catch (InterruptedException e) {
					// 忽略 //2
				}
			}
			values[top] = n;
			System.out.println("压入数字" + n + "步骤1完成");
			top++;
			dataAvailable = true;
			notifyAll();
			System.out.println("压入数字完成");
		}
	}

	public int[] pop() {
		synchronized (this) {
			while (!dataAvailable) // 3
			{
				try {
					wait();
				} catch (InterruptedException e) {
					// 忽略 //4
				}
			}
			System.out.print("弹出");
			top--;
			int[] test = { values[top], top };
			dataAvailable = false;
			// 唤醒正在等待压入数据的线程
			notifyAll();
			return test;
		}
	}
}

//读线程
class PopThread implements Runnable {

	private StackInterface s;

	public PopThread(StackInterface s) {
		this.s = s;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println("->" + s.pop()[0] + "<-");
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}

//写线程
class PuhThread implements Runnable {

	private StackInterface s;

	public PuhThread(StackInterface s) {
		this.s = s;
	}

	@Override
	public void run() {
		int i = 0;
		while (true) {
			Random r = new Random();
			i = r.nextInt();
			s.push(i);
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
