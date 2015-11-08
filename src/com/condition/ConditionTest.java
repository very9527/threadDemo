package com.condition;

/**
 * Condition 的简单应用
 * @author very9527
 * 需要和lock结合起来使用。lock.newCondition()
 */
public class ConditionTest {
	public static void main(String[] args) {
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
