package ru.trofimom.coffeemakerrestservice.model;

import javax.persistence.*;

@Entity
@Table(name = "coffeemaker")
public class CoffeeMaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "water_temperature")
    private int waterTemperature;

    @Column(name = "hard_water")
    private int hardWater;

    @Column(name = "remaining_portions_before_cleaning")
    private int remainingPortionsBeforeCleaning;

    private long datetime;

    public CoffeeMaker() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public int getWaterTemperature() {
        return waterTemperature;
    }

    public void setWaterTemperature(int waterTemperature) {
        this.waterTemperature = waterTemperature;
    }

    public int getHardWater() {
        return hardWater;
    }

    public void setHardWater(int hardWater) {
        this.hardWater = hardWater;
    }

    public int getRemainingPortionsBeforeCleaning() {
        return remainingPortionsBeforeCleaning;
    }

    public void setRemainingPortionsBeforeCleaning(int remainingPortionsBeforeCleaning) {
        this.remainingPortionsBeforeCleaning = remainingPortionsBeforeCleaning;
    }
}
