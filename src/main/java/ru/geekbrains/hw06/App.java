package ru.geekbrains.hw06;

public class App {

    public static void main(String[] args) {
        //hm06();
        hm07();
    }

    public static void hm07() {
        Cat[] cats = new Cat[5];
        cats[0] = new Cat("Барсик", 13);
        cats[1] = new Cat("Мурзик", 28);
        cats[2] = new Cat("Матроскин", 18);
        cats[3] = new Cat("Снежок", 23);
        cats[4] = new Cat("Васька",  19);
        Plate plate = new Plate(100);
        feedCats(cats, plate);
        plate.addFood(15);
        plate.info();
        feedCats(cats, plate);
    }

    private static void feedCats(Cat[] cats, Plate plate) {
        for (Cat c : cats) {
            if (!c.isSatiety()) {
                c.eat(plate);
                c.info();
                plate.info();
            }
        }
    }

    public static void hm06() {
        Animal c1 = new Cat("Барсик", 200);
        Animal c2 = new Cat("Пушок", 150);
        Animal d1 = new Dog("Бобик", 500, 10);
        Animal d2 = new Dog("Шарик", 250, 15);

        System.out.println(c1);
        c1.run(100);
        c1.run(75);
        c1.swim(10);
        c1.relax();

        c2.run(200);
        c2.swim(15);

        d1.run(1000);
        d2.run(250);
        d1.swim(5);
        d2.swim(20);

        Animal d3 = new Dog("Бублик", 200, 15);
        System.out.println(d3);

        System.out.printf("Всего создано животных %d, в т.ч. создано собак %d и котов %d\n", Animal.getCount(), Dog.getCount(), Cat.getCount());
    }

}
