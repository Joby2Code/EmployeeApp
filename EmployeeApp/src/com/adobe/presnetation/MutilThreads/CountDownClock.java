package com.adobe.presnetation.MutilThreads;

public class CountDownClock extends Thread {
	public void run() {
		for (int t = 20; t > 10; t--) {
			Thread.yield();
			System.out.println("Inside CountdownClock class " + this.getName());
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		System.out.println("Exiting CountDownClock Thread");
	}

}