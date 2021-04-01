package ru.geekbrains.hw11;

public class Apple extends Fruit {

    private static final float WEIGHT_APPLE = 1.0f;

    @Override
    public float getWeight() {
        return WEIGHT_APPLE;
    }

    @Override
    public String toString() {
        return "Яблоко{" + super.getId() + "}";
    }
}
