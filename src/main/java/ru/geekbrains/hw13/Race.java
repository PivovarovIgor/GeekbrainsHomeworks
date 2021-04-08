package ru.geekbrains.hw13;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Race {
    private ArrayList<Stage> stages;
    private final Lock lock;
    private final CountDownLatch allFinish;
    private boolean haveWinner;
    private final Set<Car> finishedCars;

    public ArrayList<Stage> getStages() {
        return stages;
    }

    public Race(CountDownLatch allFinish, Stage... stages) {
        this.stages = new ArrayList<>(Arrays.asList(stages));
        this.lock = new ReentrantLock();
        this.allFinish = allFinish;
        this.finishedCars = new HashSet<>();
    }

    public void finish(Car car) {
        try {
            lock.lock();
            if (finishedCars.contains(car)) {
                return; // один и тот же автомобиль не может финишировать несколько раз
            }
            finishedCars.add(car);
            System.out.println("Финишировал " + car.getName());
            if (!haveWinner) {
                haveWinner = true;
                System.out.println("ВАЖНОЕ ОБЪЯВЛЕНИЕ >>> Победитель " + car.getName());
            }
            allFinish.countDown();
        } finally {
            lock.unlock();
        }
    }
}
