package ru.geekbrains.hw07;

public class Cat {

    private final String name;
    private boolean satiety = false;
    private final int appetite;

    public Cat(String name, int appetite) {
        this.name = name;
        this.appetite = appetite;
    }

    public void eat(Plate p) {
        if (p.decreaseFood(appetite)) {
            System.out.println(toString() + " - поел");
            satiety = true;
        }
    }

    public boolean isSatiety() {
        return satiety;
    }

    public int getAppetite() {
        return appetite;
    }

    public void info() {
        System.out.println(name + " " + name + " - " + ((satiety) ? "сытый" : "голодный"));
    }

}
