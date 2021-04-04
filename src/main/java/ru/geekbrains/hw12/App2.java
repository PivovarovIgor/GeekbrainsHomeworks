package ru.geekbrains.hw12;

public class App2 {

    public static void main(String[] args) {

        final Object lock1 = new Object();
        final Object lock2 = new Object();

        var app = new App2();
        new Thread(() -> app.method1(lock1)).start();
        new Thread(() -> app.method1(lock1)).start();

        new Thread(() -> app.method1(lock2)).start();
        new Thread(() -> app.method1(lock2)).start();
    }

    private void method1(Object lock) {
        System.out.println("Начало паралельного блока " + Thread.currentThread().getName());
        for (int i = 0; i < 10; i++) {
            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Работает поток " + Thread.currentThread().getName() + " " + i);
        }
        System.out.println("Окончание паралельного блока" + Thread.currentThread().getName());
        synchronized (lock) {
            System.out.println("Начало синхронизированного блока " + Thread.currentThread().getName());
            for (int i = 0; i < 10; i++) {
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("Работает поток " + Thread.currentThread().getName() + " " + i);
            }
            System.out.println("Окончание синхронизированного блока" + Thread.currentThread().getName());
        }
    }

}
