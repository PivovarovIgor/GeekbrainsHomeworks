package ru.geekbrains.hw08;

public class Wall implements Hindrance {

    private final float height;
    private final int idInstance;
    private static int id = 0;

    public Wall(float height) {
        this.height = height;
        idInstance = ++id;
    }

    public float getHeight() {
        return height;
    }

    @Override
    public boolean overcome(Player p) {
        return p.jump(this);
    }

    @Override
    public String toString() {
        return "стена{" +
                "height=" + height +
                ", idInstance=" + idInstance +
                '}';
    }
}
