package com.timer;

import java.util.Timer;
import java.util.TimerTask;

/**
 * 传统的定时器
 * @author very9527
 *
 */
public class TraditionTimerTest {
	public static void main(String[] args) {
		
		// 备注：定时器里面调度（schedule）的不是runnable, 而是TimeTask
		new Timer().schedule(new TimerTask(){
			@Override
			public void run() {
				System.out.println("Task Start");
			}
		}, 2000);
	}
}
