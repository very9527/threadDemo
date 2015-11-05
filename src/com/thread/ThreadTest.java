package com.thread;

public class ThreadTest extends Thread{
	public static void main(String[] args) {
		Thread thread = new Thread();
		thread.start();
	}
	
	public void run() {
		System.out.println("Hello world");
	}
}
