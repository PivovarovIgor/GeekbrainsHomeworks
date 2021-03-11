package hw06;

public abstract class Animal {

    private final String name;
    private final double maxRun;
    private final double maxSwim;
    private double leftToRun;
    private double leftToSwim;

    private static int count = 0;

    public static int getCount() {
        return count;
    }

    public Animal(String name, double maxRun, double maxSwim) {
        Animal.count++;
        this.name = name;
        this.maxRun = maxRun;
        this.maxSwim = maxSwim;
        this.leftToRun = maxRun;
        this.leftToSwim = maxSwim;
    }

    public Animal(String name, double maxRun) {
        this(name, maxRun, 0);
    }

    @Override
    public String toString() {
        String result = this.name;
        if (this.maxRun > 0 || this.maxRun > 0) {
            result = result + " {запас";
            if (this.maxRun > 0) {
                result = result + " бега " + this.leftToRun;
            }
            if (this.maxSwim > 0) {
                result = result + "; плаванья " + this.leftToSwim;
            }
            result = result + "}";
        }
        return result;
    }

    public double getLeftToRun() {
        return leftToRun;
    }

    public double getLeftToSwim() {
        return leftToSwim;
    }

    public void relax() {
        this.leftToRun = this.maxRun;
        this.leftToSwim = this.maxSwim;
        System.out.printf("%s - отдохнул, сейчас может пробежать %f и проплыть %f\n", this.toString(), this.getLeftToRun(), this.getLeftToSwim());
    }

    public void run(double distance) {
        if (distance < 0) {
            System.out.println("Дистанция не может быть отрицательной!");
            return;
        }

        if (this.maxRun == 0) {
            System.out.printf("%s не бегает\n", this.toString());
        } else if (this.leftToRun >= distance) {
            this.leftToRun -= distance;
            System.out.printf("%s пробежал(а) %f метров. Ещё может пробежать %f\n", this.toString(), distance, this.leftToRun);
        } else {
            System.out.printf("%s - не может пробежать %f. Хватит сил пробежать только %f метров\n", this.toString(), distance, this.leftToRun);
        }
    }

    public void swim(double distance)  {
        if (distance < 0) {
            System.out.println("Дистанция не может быть отрицательной!");
            return;
        }

        if (this.maxSwim == 0) {
            System.out.printf("%s не плавает\n", this.toString());
        } else if (this.leftToSwim >= distance) {
            this.leftToSwim -= distance;
            System.out.printf("%s проплыл(а) %f метров. Ещё может проплыть %f\n", this.toString(), distance, this.leftToSwim);
        } else {
            System.out.printf("%s - Не может проплыть %f. Хватит сил проплыть только %f метров\n", this.toString(), distance, this.leftToSwim);
        }
    }

}
