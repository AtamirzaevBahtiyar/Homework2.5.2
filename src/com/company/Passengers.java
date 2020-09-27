package com.company;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.Semaphore;

public class Passengers extends Thread {

    private Semaphore sem;
    private CountDownLatch cdl;
    private int id;


    public Passengers(Semaphore sem, CountDownLatch cdl, int id) {
        this.sem = sem;
        this.cdl = cdl;
        this.id = id;
    }

    public void run(){
        try {
            sem.acquire();
            System.out.println("Покупает билет пассажир №: " + id);
            sleep(2000);
            System.out.println("Пассажир №:" + id + " купил билет");
            sem.release();
            sleep(1000);
            System.out.println("Пассажир №:" + id + " сел в автобус");
            cdl.countDown();

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
