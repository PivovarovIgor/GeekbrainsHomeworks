package hw07;

public class App {

    public static void main(String[] args) {
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
}
