package com.adobe.presnetation.MutilThreads;

public class NewThread implements Runnable {

	Thread T = new Thread();
	Thread L;
	String name1;
	private static int count;

	public NewThread() {
		T = new Thread(this, "CHILD THREAD");// this operator signifies to
		// start
		T.setName("ChildThread_" + count); // the child process

		// T = new Thread();
		System.out.println("Thread of child " + T.getName());
		T.start(); // Used To start the threads in the run method

	}

	public NewThread(String name) {
		// T = new Thread(this, "CHILD THREAD");// this operator signifies to
		// start
		T.setName(name); // the child process

		// T = new Thread("Creating thread");
		System.out.println("NewThread of child " + T.getName());
		T.start(); // Used To start the threads in the run method

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			for (int j = 60; j > 50; j--) {
				// System.out.println("Child thread" + j);
				System.out.println(Thread.currentThread().getName()
						+ " child count " + j);
				Thread.sleep(1000);// Used to sleep the thread by the time
									// specified in sec
			}
		} catch (InterruptedException e) {
			System.out.println("Child interrrupted");
		}
		System.out.println("Exiting child at ");
		count = count + 1;
	}

}
