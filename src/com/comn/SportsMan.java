package com.comn;

public class SportsMan {
	boolean yaomingHasBall = true;
	String lock = "1324";
	
	public void isWatched() {
		try {
			Thread.sleep(1000);
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		synchronized(SportsMan.class){
			if (!yaomingHasBall) {
				try {
					SportsMan.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
			System.out.println("Yao Ming is playing basketball");
			yaomingHasBall = false;
			SportsMan.class.notify();
		}
	}
	
	public  void isWatchedToo() {
		synchronized(SportsMan.class){
			if (yaomingHasBall) {
		
				try {
					SportsMan.class.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
			System.out.println("Kobe is playing basketball");
			yaomingHasBall = true;
			SportsMan.class.notify();
		}
	}
	
}
