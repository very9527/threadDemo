package com.comn;

public class TraditionalThreadCommunication {
	public static void main(String[] args) {
		// 错了的地方：1、把循环写在最外面了
		// 2、用 SportsMan.class 做锁报错。
		//（如果用 SportsMan.class 那么 notify 和 wait 也应该写成 SportsMan.class.wait 和 SportsMan.class.notify）
		// 3、sleep 和 wait 的区别 ： sleep 是线程 sleep. wait 是等待锁。
		SportsMan sportsMan = new SportsMan();
		new Thread (new Runnable(){
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
				sportsMan.isWatched();
				}
			}
		}).start();
	
		new Thread (new Runnable(){
			@Override
			public void run() {
				for (int i = 0; i < 100; i++) {
					sportsMan.isWatchedToo();
				}
			}
		}).start();
	}
}
