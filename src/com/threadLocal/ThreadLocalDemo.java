package com.threadLocal;

import java.util.Random;

/**
 * ThreadLocal 的使用
 * @author very9527
 *
 */
public class ThreadLocalDemo {
	private static ThreadLocal threadLocal = new ThreadLocal();
	public static void main(String[] args) {
		for (int i = 0; i<2; i++) {
			new Thread(new Runnable(){
				@Override
				public void run() {
					int data = new Random().nextInt();
					System.out.println(Thread.currentThread().getName() + " has put data = " + data);
					threadLocal.set(data);
					new A().get();
					new B().get();
				}
			}).start();
		}
		
	}
	
	static class A {
		public void get() {
			int data = (int)threadLocal.get();
			System.out.println("A from " + Thread.currentThread().getName() + " get data : " + data);
		}
	}
	
	static class B {
		public void get() {
			int data = (int)threadLocal.get();
			System.out.println("B from " + Thread.currentThread().getName() + " get data : " + data);
		}
	}
}
