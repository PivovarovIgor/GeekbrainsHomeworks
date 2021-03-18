package ru.geekbrains.hw08;

public class App {

    public static void main(String[] args) {

        Player[] players = new Player[3];
        players[0] = new Human("Василий");
        players[1] = new Cat("Мурзик");
        players[2] = new Robot("JR45");

        Hindrance[] hindrances = new Hindrance[5];
        hindrances[0] = new RunningTrack(28);
        hindrances[1] = new Wall(0.4f);
        hindrances[2] = new RunningTrack(79.6f);
        hindrances[3] = new Wall(7.5f);
        hindrances[4] = new RunningTrack(300);

        for (Player p : players) {
            for (Hindrance h : hindrances) {
                if (!h.overcome(p)) {
                    System.out.println(p.toString() + " - выбыл");
                    break;
                }
            }
        }
    }
}
