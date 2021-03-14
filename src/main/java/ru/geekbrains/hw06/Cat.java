package ru.geekbrains.hw06;

public class Cat extends Animal {

    private final static double DEFAULT_MAX_RUN = 200;

    private static int count = 0;

    private static void count() {
        Cat.count++;
    }

    public static int getCount() {
        return count;
    }

    public Cat(String name, double maxRun) {
        super(name, maxRun);
        count();
    }

    public Cat(String name, int appetite) {
        super(name, appetite);
        count();
    }

    @Override
    public String toString() {
        return String.format("Кот '%s'", super.toString());
    }
}
