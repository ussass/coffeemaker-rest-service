package ru.trofimom.coffeemakerrestservice.model;

public enum Level {
    LOW(1),
    MEDIUM(2),
    HIGH(3);

    private int level;

    Level(int level) {
        this.level = level;
    }

    public int getLevel() {
        return level;
    }
}
