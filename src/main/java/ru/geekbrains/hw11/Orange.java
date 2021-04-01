package ru.geekbrains.hw11;

public class Orange extends Fruit {

    private static final float WEIGHT_ORANGE = 1.5f;

    @Override
    public float getWeight() {
        return WEIGHT_ORANGE;
    }

    @Override
    public String toString() {
        return "Апельсин{"+ super.getId() +"}";
    }
}
