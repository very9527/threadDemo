package com.lock;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockTest {
	public static void main(String[] args) {
		final Outputer outputer = new Outputer();
		new Thread(new Runnable(){
			@Override
			public void run() {
				for (int i = 0; i <100; i++) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output("yuminghong");
				}
			}
		}).start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				for (int i = 0; i <100; i++) {
					try {
						Thread.sleep(10);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
					outputer.output("zhangxiaoxiang");
				}
			}
		}).start();
	}
	
	static class Outputer {
		Lock lock = new ReentrantLock(); // 锁的初始化应该在方法的外面。和锁的生命周期对应。
		public void output(String name) {
			lock.lock();
			int length = name.length();
			for (int i = 0; i < length; i++) {
				System.out.print(name.charAt(i));
			}
			System.out.println();
			lock.unlock();
		}
	}
}
