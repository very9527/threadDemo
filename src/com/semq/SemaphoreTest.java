package com.semq;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * 信号量。
 * 关键点：信号量的控制语句是写在线程 run() 方法内部。
 * @author very9527
 *
 */
public class SemaphoreTest {
	public static void main(String[] args) {
		ExecutorService exec = Executors.newCachedThreadPool();
		Semaphore semp = new Semaphore(6);
		for (int i = 0; i < 51; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						semp.acquire();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					System.out.println("线程 " + Thread.currentThread().getName() + "正在执行， 线程并发数 ：" + (6-semp.availablePermits()));
					
					semp.release();
				}
			};
			exec.execute(runnable);
		}
	}
}
