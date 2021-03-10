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

    @Override
    public void run(double distance) {
        Animal.run(this, distance);
    }

    @Override
    public void swim(double distance) {
        Animal.swim(this, distance);
    }

    @Override
    public void relax() {
        super.relax();
        System.out.printf("%s - отдохнул, сейчас может пробежать %f и проплыть %f\n", this.toString(), this.getLeftToRun(), this.getLeftToSwim());
    }
}
