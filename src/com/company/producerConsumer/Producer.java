package com.company.producerConsumer;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

public class Producer implements Runnable {
    private LinkedBlockingDeque<Product> store;

    Random random = new Random(System.currentTimeMillis());

    public Producer(LinkedBlockingDeque<Product> store) {
        this.store = store;
    }

    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            try {
                store.offer(new Product(i));
                System.out.println(Thread.currentThread().getName() + ": produce product " + i + ", store size " + store.size());
                Thread.sleep(1000 * random.nextInt(3));
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
    }
}
