/*
 * Copyright (c) 2017. Balamurugan Tamilmani (balamurugan.leo@gmail.com). All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are not permitted.
 */
package com.balatamilmani;

import com.balatamilmani.task.CustomTask;

/**
 * Main method spans two new Threads and those supposed to run forever When both
 * the Threads died, raise an ALARM (such as email) and exit
 *
 */
public class ThreadMonitor {
	private static final int DELAY_TO_CHECK_THREADS = 2000;

	public static void main(String[] args) throws Exception {
		System.out.println("About to start Threads!");
		startThreads();
		System.out.println("Threads are started. Back in main");
		while (true) {
			int threadCount = Thread.activeCount();
			System.out.println("Number of active Threads:: " + threadCount);
			if (threadCount == 1) {
				//Only main Thread alive
				System.out.println("ALARM:: Other Threads died, exiting main Thread");
				System.exit(1);
			}
			//Sleep for specific seconds before checking the Threads are alive
			Thread.sleep(DELAY_TO_CHECK_THREADS);
		}
	}

	private static void startThreads() throws InterruptedException {
		Thread t1 = new Thread(new CustomTask(2000));
		//Daemon thread allows jvm to exit, non Daemons doesn't allow
		// t1.setDaemon(true); 
		t1.start();

		Thread t2 = new Thread(new CustomTask(4000));
		t2.start();
	}
}
