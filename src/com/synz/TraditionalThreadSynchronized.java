package com.synz;

public class TraditionalThreadSynchronized {
	public static void main(String[] args) {
		Outputer outputer = new Outputer();
		for (int i = 0; i < 100; i++) {
			new Thread(new Runnable(){
	
				@Override
				public void run() {
					new Outputer().output("yuminghong");
				}
				
			}).start();
			
			new Thread(new Runnable(){
				
				@Override
				public void run() {
					new Outputer().output("zhangxiaoxiang");
				}
				
			}).start();
		}
	}
	
	
}


