package ru.geekbrains.hw08;

public class Human implements Player {

    private final String name;
    private final float runLimit = 100f;
    private final float jumpLimit = 1.5f;

    public Human(String name) {
        this.name = name;
    }

    @Override
    public boolean jump(Wall w) {
        if (w.getHeight() <= jumpLimit) {
            System.out.println(this.toString() + " - препрыгнул '" + w.toString() + "'");
            return true;
        } else {
            System.out.println(this.toString() + " - не удалось перепрыгнуть '" + w.toString() + "'");
        }
        return false;
    }

    @Override
    public boolean run(RunningTrack rt) {
        if (rt.getLength() <= runLimit) {
            System.out.println(this.toString() + " - пробежал '" + rt.toString() + "'");
            return true;
        } else {
            System.out.println(this.toString() + " - не удалось пробежать '" + rt.toString() + "'");
        }
        return false;
    }

    @Override
    public String toString() {
        return "Человек " + name + "{runLimit=" + runLimit +
                ", jumpLimit=" + jumpLimit +
                '}';
    }
}
