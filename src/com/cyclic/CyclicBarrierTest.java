package com.cyclic;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class CyclicBarrierTest {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final CyclicBarrier cb = new CyclicBarrier(3);
		for (int i = 0; i < 3; i++) {
			Runnable runnable = new Runnable() {
				@Override
				public void run() {
					try {
						Thread.sleep((long)Math.random()*10000);
						System.out.println("线程 " + Thread.currentThread().getName() + " 到达集合点1");
						cb.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					try {
						Thread.sleep((long)Math.random()*10000);
						System.out.println("线程 " + Thread.currentThread().getName() + " 到达集合点2");
						cb.await();
					} catch (Exception e) {
						e.printStackTrace();
					}
					
					try {
						Thread.sleep((long)Math.random()*10000);
						System.out.println("线程 " + Thread.currentThread().getName() + " 到达集合点3");
						cb.await();
						System.out.println("开始出发");
					} catch (Exception e) {
						e.printStackTrace();
					}
					
				}
			};
			service.execute(runnable);
		}
	}
}
