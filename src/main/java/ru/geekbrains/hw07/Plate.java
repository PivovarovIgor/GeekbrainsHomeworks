package ru.geekbrains.hw07;

public class Plate {

    private int food;

    public Plate(int food) {
        this.food = food;
    }

    public boolean decreaseFood(int n) {
        boolean foodEnough = false;
        if (food >= n) {
            food -= n;
            foodEnough = true;
        }
        return foodEnough;
    }

    public void addFood(int n) {
        if (n > 0) {
            food += n;
        }
    }

    public void info() {
        System.out.println("Количество еды в тарелке: " + food);
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

}
