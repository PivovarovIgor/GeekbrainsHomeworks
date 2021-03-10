package hw06;

public class App {

    public static void main(String[] args) {
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

        System.out.printf("Всего созжано животных %d, в т.ч. создано собак %d и котов %d", Animal.getCount(), Dog.getCount(), Cat.getCount());

    }

}
