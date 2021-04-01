package ru.geekbrains.hw11;

import java.util.ArrayList;

public class Box<T extends Fruit> implements Comparable {

    private String name;
    private final ArrayList<T> elements;

    private Box() {
        this.elements = new ArrayList<>();
    }

    public Box(String name) {
        this();
        this.name = name;
    }


    public float getWeight() {
        if (elements.isEmpty()) {
            return 0;
        }
        return elements.size() * elements.get(0).getWeight();
    }

    @Override
    public <C extends Box> boolean compare(C fr) {
        return Math.abs(getWeight() - fr.getWeight()) < 0.01f;
    }

    public boolean add(T el) {
        return elements.add(el);
    }

    public T extract() {
        if (elements.isEmpty()) {
            return null;
        }
        return elements.remove(elements.size() - 1);
    }

    public void pourTo(Box<T> destBox) {
        for (int i = elements.size() - 1; i >= 0; i--) {
            destBox.add(elements.remove(i));
        }
    }

    @Override
    public String toString() {
        return "Коробка \""+ name + "\" {" + elements +
                '}';
    }

    public String getName() {
        return name;
    }
}
