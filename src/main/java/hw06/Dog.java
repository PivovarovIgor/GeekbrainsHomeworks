package hw06;

public class Dog extends Animal {

    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public Dog(String name, double maxRun, double maxSwim) {
        super(name, maxRun, maxSwim);
        Dog.count++;
    }

    @Override
    public String toString() {
        return String.format("Собака '%s'", super.toString());
    }
}
