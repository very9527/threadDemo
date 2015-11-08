package com.readWrite;

import java.util.Random;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

public class ReadWriteTest {
	public static void main(String[] args) {
		final Queue queue = new Queue();
		for (int i = 0; i <3; i++) {
			new Thread(new Runnable(){
				@Override
				public void run() {
					while(true) {
						queue.get();
					}
				}
			}).start();
			
			new Thread(new Runnable(){
				@Override
				public void run() {
					while(true) {
						queue.put(new Random().nextInt(10000));
					}
				}
			}).start();
		}
	}
	
	static class Queue {
		private Object data = null;
		ReadWriteLock rwLock = new ReentrantReadWriteLock(); // 锁的初始化应该在方法的外面。和锁的生命周期对应。
		public void put(Object data) {
			rwLock.writeLock().lock();
			System.out.println("线程: " + Thread.currentThread().getName() + " 开始写");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			this.data = data;
			System.out.println("线程: " + Thread.currentThread().getName() + " 已经写完 ： data = " +this.data);
			rwLock.writeLock().unlock();
		}
		
		public void get() {
			rwLock.readLock().lock();
			System.out.println("线程: " + Thread.currentThread().getName() + " 开始读");
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("线程: " + Thread.currentThread().getName() + " 已经读完 ： data = " +data);
			rwLock.readLock().unlock();
		}
	}
}
