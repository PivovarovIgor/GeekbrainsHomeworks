package hw06;

public class Cat extends Animal {

    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public Cat(String name, double maxRun) {
        super(name, maxRun);
        Cat.count++;
    }

    @Override
    public String toString() {
        return String.format("Кот '%s'", super.toString());
    }
}
