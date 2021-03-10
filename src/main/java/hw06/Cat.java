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
