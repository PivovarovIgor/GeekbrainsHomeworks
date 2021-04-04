package ru.geekbrains.hw12;

import java.util.Arrays;
import java.util.Objects;

public class App {

    public static void main(String[] args) {

        Thread[] t = new Thread[6];

        var cnt = new Counter();

        System.out.println("запуск потоков");
        var timeBegin = System.currentTimeMillis();
        t = Arrays.stream(t)
                .map(el -> el = new Thread(new MyThread(cnt)))
                .toArray(Thread[]::new);
        for (Thread el : t) {
            el.start();
        }
        System.out.println("потоки запущены. Время запуска потоков " + (System.currentTimeMillis() - timeBegin));
        timeBegin = System.currentTimeMillis();
        Arrays.stream(t)
                .forEach(thread -> {
                    try {
                        thread.join();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                });
        System.out.println("Выполнение потоков завершено. Результат счёдчика " + cnt.getC() +
                "\nВремя выполнение всех потоков " + (System.currentTimeMillis() - timeBegin));
    }
}

class Counter {
    private volatile long c;
    private final Object monitor;

    public Counter() {
        monitor = new Object();
    }

    public long getC() {
        return c;
    }

    public void count() {
        synchronized (monitor) {
            c++;
        }
    }
}

class MyThread implements Runnable {

    private final Counter counter;

    public MyThread(Counter counter) {
        this.counter = counter;
    }

    @Override
    public void run() {

        System.out.println("Начало выполнение потока: " + Thread.currentThread().getName());
        for (int i = 0; i < 1000000; i++) {
            counter.count();
        }
        System.out.println("Окончание выполнения потока " + Thread.currentThread().getName());
    }
}