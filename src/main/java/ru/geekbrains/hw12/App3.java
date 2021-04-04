package ru.geekbrains.hw12;

import java.util.ArrayList;

public class App3 {

    public static void main(String[] args) {

        House house = new House();
        Pizza pizza = new Pizza();

        Thread pizzaEater = new Thread(new PizzaEater(house));
        Thread deliveryman = new Thread(new Deliveryman(pizza, house));

        pizzaEater.start();
        deliveryman.start();
    }
}

class Pizza {

}

class House {

    private final ArrayList<Pizza> pizzaList;

    public House() {
        pizzaList = new ArrayList<>();
    }

    public void setPizza(Pizza pizza) {
        pizzaList.add(pizza);
    }

    public Pizza getPizza() {
        if (pizzaList.size() == 0) {
            return null;
        }
        return pizzaList.remove(pizzaList.size() - 1);
    }
}

class PizzaEater implements Runnable {

    private final House house;

    public PizzaEater(House house) {
        this.house = house;
    }

    @Override
    public void run() {
        synchronized (house) {
            while (house.getPizza() == null) {
                System.out.println("Заказчик: Жду мою питцу");
                try {
                    house.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Заказчик: поем пицу");
            house.notify();
        }
    }
}

class Deliveryman implements Runnable {

    private Pizza pizza;
    private House house;

    Deliveryman(Pizza pizza, House house) {
        this.pizza = pizza;
        this.house = house;
    }

    @Override
    public void run() {
        synchronized (house) {
            System.out.println("Доставщик: повёз питцу");
            for (int i = 0; i < 5; i++) {
                System.out.println("Доставщик: везу питцу. Пройдено пути " + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            house.setPizza(pizza);
            System.out.println("Доставщик: питца доставдена");
            house.notify();
            System.out.println("Доставщик: жду ответа заказчика");
            try {
                house.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("Доставщик: ответ получен");
        }
    }
}