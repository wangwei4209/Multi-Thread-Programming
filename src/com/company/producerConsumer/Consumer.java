package com.company.producerConsumer;

import java.util.Random;
import java.util.concurrent.LinkedBlockingDeque;

public class Consumer implements Runnable {
    private LinkedBlockingDeque<Product> store;

    Random random = new Random(System.currentTimeMillis());

    public Consumer(LinkedBlockingDeque<Product> store) {
        this.store = store;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Product product = store.take();
                System.out.println(Thread.currentThread().getName() + ": consume product " + product.getId() + ", store size " + store.size());
                Thread.sleep(1000 * random.nextInt(10));
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }
        }
    }
}
