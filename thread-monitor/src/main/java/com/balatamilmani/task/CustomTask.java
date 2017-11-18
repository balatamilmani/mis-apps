/*
 * Copyright (c) 2017. Balamurugan Tamilmani (balamurugan.leo@gmail.com). All rights reserved.
 *
 * Redistribution and use in source and binary forms, with or without
 * modification, are not permitted.
 */
package com.balatamilmani.task;

public class CustomTask implements Runnable {

	int waitTime;
	public CustomTask(int waitTime){
		this.waitTime = waitTime;
	}
	public void run() {
		int counter = 0;
		while(counter<5){
			try {
				System.out.println(Thread.currentThread().getName()+":: In CustomTask, about to sleep "+counter);
				Thread.sleep(waitTime);
				counter++;
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

}
