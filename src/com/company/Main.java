package com.company;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingDeque;

public class Main {
    public static void main(String[] args) {
        ExecutorService producers = Executors.newFixedThreadPool(1);
        ExecutorService consumers = Executors.newFixedThreadPool(3);

        LinkedBlockingDeque<Product> store = new LinkedBlockingDeque<>(100);
        producers.submit(new Producer(store));

        consumers.submit(new Consumer(store));
        consumers.submit(new Consumer(store));
        consumers.submit(new Consumer(store));
    }
}
