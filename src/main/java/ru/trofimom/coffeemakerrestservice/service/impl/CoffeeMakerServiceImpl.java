package ru.trofimom.coffeemakerrestservice.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.trofimom.coffeemakerrestservice.model.CoffeeMaker;
import ru.trofimom.coffeemakerrestservice.model.Level;
import ru.trofimom.coffeemakerrestservice.repositories.CoffeeMakerRepository;
import ru.trofimom.coffeemakerrestservice.response.ResultResponse;
import ru.trofimom.coffeemakerrestservice.service.CoffeeMakerService;
import ru.trofimom.coffeemakerrestservice.service.ResourceCheckingService;

@Service
public class CoffeeMakerServiceImpl implements CoffeeMakerService {

    private final ResourceCheckingService resourceCheckingService;

    private final CoffeeMakerRepository coffeeMakerRepository;

    @Value("${totalServingBeforeCleaning}")
    private int totalCupsBeforeCleaning;

    public CoffeeMakerServiceImpl(ResourceCheckingService resourceCheckingService, CoffeeMakerRepository coffeeMakerRepository) {
        this.resourceCheckingService = resourceCheckingService;
        this.coffeeMakerRepository = coffeeMakerRepository;
    }

    @Override
    public ResultResponse makeCoffee(int cups) {
        if (!resourceCheckingService.waterLevelCheck()) {
            return new ResultResponse("Not water");
        }
        CoffeeMaker coffeeMaker = coffeeMakerRepository.findTopByOrderByIdDesc();
        if (coffeeMaker == null) {
            coffeeMaker = new CoffeeMaker(
                    Level.MEDIUM.getLevel(),
                    Level.MEDIUM.getLevel(),
                    totalCupsBeforeCleaning - cups * Level.MEDIUM.getLevel());
        } else {
            coffeeMaker = new CoffeeMaker(
                    coffeeMaker.getWaterTemperature(),
                    coffeeMaker.getHardWater(),
                    coffeeMaker.getRemainingCupsBeforeCleaning() - cups * coffeeMaker.getHardWater());
        }

        coffeeMakerRepository.save(coffeeMaker);

        return new ResultResponse("Start making coffee");
    }

    @Override
    public ResultResponse setParameters(Integer waterTemperature, Integer hardWater) {

        if (waterTemperature == null && hardWater == null)
            return new ResultResponse("No data to save");
        if (hardWater < 1 || hardWater > 3)
            return new ResultResponse("Parameter 'hardWater' must be from 1 to 3");
        if (waterTemperature < 1 || waterTemperature > 3)
            return new ResultResponse("Parameter 'waterTemperature' must be from 1 to 3");

        CoffeeMaker coffeeMaker = coffeeMakerRepository.findTopByOrderByIdDesc();
        if (coffeeMaker == null) {
            coffeeMaker = new CoffeeMaker(
                    waterTemperature == null ? Level.MEDIUM.getLevel() : waterTemperature,
                    hardWater == null ? Level.MEDIUM.getLevel() : hardWater,
                    totalCupsBeforeCleaning);
        } else {
            coffeeMaker = new CoffeeMaker(
                    waterTemperature == null ? coffeeMaker.getWaterTemperature() : waterTemperature,
                    hardWater == null ? coffeeMaker.getHardWater() : hardWater,
                    coffeeMaker.getRemainingCupsBeforeCleaning());
        }

        coffeeMakerRepository.save(coffeeMaker);

        return new ResultResponse("Parameters saved");
    }

    @Override
    public ResultResponse showCondition() {
        return null;
    }

    @Override
    public ResultResponse cleaning() {
        return null;
    }
}
