package com.company;

import java.util.concurrent.CountDownLatch;

public class Bus extends Thread {

    CountDownLatch countDownLatch;


    public Bus(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        super.run();
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Автобус поехал в Ош");
    }
}


