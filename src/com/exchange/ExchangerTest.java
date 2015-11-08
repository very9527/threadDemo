package com.exchange;

import java.util.concurrent.Exchanger;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Exchange工具类
 * @author very9527
 *
 */
public class ExchangerTest {
	public static void main(String[] args) {
		ExecutorService service = Executors.newCachedThreadPool();
		final Exchanger<String> exchanger = new Exchanger();
		new Thread(new Runnable(){
			@Override
			public void run() {
				String clothes = "一件银鳞胸甲";
				String exchangedCoins = "";
				try {
					System.out.println(Thread.currentThread().getName() + " 拥有"+ clothes +", 开始准备交换");
					Thread.sleep(10000);
					exchangedCoins = (String)exchanger.exchange(clothes);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " 换得金币" + exchangedCoins);
			}
		}).start();
		
		new Thread(new Runnable(){
			@Override
			public void run() {
				String goldCoin = "5G";
				String exchangedClothes = "";
				try {
					System.out.println(Thread.currentThread().getName() + " 拥有"+ goldCoin +", 开始准备交换");
					Thread.sleep(1);
					exchangedClothes = (String)exchanger.exchange(goldCoin);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println(Thread.currentThread().getName() + " 换得" + exchangedClothes);
			}
		}).start();
	}
}
