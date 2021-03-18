package ru.geekbrains.hw08;

public class RunningTrack implements Hindrance {

    private final float length;
    private final int idInstance;
    private static int id = 0;

    public RunningTrack(float length) {
        this.length = length;
        idInstance = ++id;
    }

    public float getLength() {
        return length;
    }

    @Override
    public boolean overcome(Player p) {
        return p.run(this);
    }

    @Override
    public String toString() {
        return "беговая дорожка{" +
                "length=" + length +
                ", idInstance=" + idInstance +
                '}';
    }
}
