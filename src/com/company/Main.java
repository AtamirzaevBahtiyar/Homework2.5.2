package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Main {
    private static int quantityOfPassengers = 100;

    public static void main(String[] args) {

        Semaphore semaphore = new Semaphore(4);
        CountDownLatch countDownLatch = new CountDownLatch(quantityOfPassengers);
        new Bus(countDownLatch).start();
        for (int i = 0; i < quantityOfPassengers; i++) {
            new Passengers(semaphore, countDownLatch,i+1).start();

        }
    }
}
