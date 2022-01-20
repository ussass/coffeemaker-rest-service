package ru.trofimom.coffeemakerrestservice.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "coffeemaker")
public class CoffeeMaker {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @JsonIgnore
    private long id;

    @Column(name = "water_temperature")
    private int waterTemperature;

    @Column(name = "hard_water")
    private int hardWater;

    @Column(name = "remaining_cups_before_cleaning")
    private int remainingCupsBeforeCleaning;

    @JsonIgnore
    private long datetime;

    public CoffeeMaker() {
    }

    public CoffeeMaker(int waterTemperature, int hardWater, int remainingCupsBeforeCleaning) {
        this.waterTemperature = waterTemperature;
        this.hardWater = hardWater;
        this.remainingCupsBeforeCleaning = remainingCupsBeforeCleaning;
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyyMMddHHmmss");
        LocalDateTime now = LocalDateTime.now();
        datetime = Long.parseLong(dateTimeFormatter.format(now));
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

    public int getRemainingCupsBeforeCleaning() {
        return remainingCupsBeforeCleaning;
    }

    public void setRemainingCupsBeforeCleaning(int remainingCupsBeforeCleaning) {
        this.remainingCupsBeforeCleaning = remainingCupsBeforeCleaning;
    }
}
