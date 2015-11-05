package com.thread;

public class RunableTest {
	public static void main(String[] args) {
		new Thread(new Runnable(){
			@Override
			public void run() {
				System.out.println("Hello World");
			}
		}).start();
	}
}
