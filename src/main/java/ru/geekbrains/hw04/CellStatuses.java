package ru.geekbrains.hw04;

public enum CellStatuses {

    EMPTY(" . "),
    SHIP(" . "),
    HIT_SHIP("[X]"),
    HIT(" x ");

    private String represent;

    CellStatuses(String r) {
        this.represent = r;
    }

    public static void setDebugMode(boolean debugMode) {
        SHIP.represent = (debugMode) ? "[ ]" : " . ";
    }

    @Override
    public String toString() {
        return represent;
    }
}
