package com.condition;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SportsMan {
	final Lock lock = new ReentrantLock();
	Condition condition = lock.newCondition();
	private boolean yaomingHasBall = false;
	
	public void isWatched() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		lock.lock();
		if (!yaomingHasBall) {
			try {
				condition.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		System.out.println("Yao Ming is playing basketball");
		yaomingHasBall = false;
		condition.signal();
		lock.unlock();
	}
	
	public  void isWatchedToo() {
		lock.lock();
		if (yaomingHasBall) {
			try {
				condition.await();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		} 
		System.out.println("Kobe is playing basketball");
		yaomingHasBall = true;
		condition.signal();
		lock.unlock();
	}
	
}
