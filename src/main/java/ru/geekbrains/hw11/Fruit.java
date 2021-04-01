package ru.geekbrains.hw11;

public abstract class Fruit {

    private static int count;
    private final int id;

    public Fruit() {
        id = ++count;
    }

    protected int getId() {
        return id;
    }

    public abstract float getWeight();

}
