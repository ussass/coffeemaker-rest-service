package ru.trofimom.coffeemakerrestservice.model;

public class Parameters {

    private final int waterTemperature;

    private final int hardWater;

    public Parameters(int waterTemperature, int hardWater) {
        this.waterTemperature = waterTemperature;
        this.hardWater = hardWater;
    }

    public int getWaterTemperature() {
        return waterTemperature;
    }

    public int getHardWater() {
        return hardWater;
    }
}
