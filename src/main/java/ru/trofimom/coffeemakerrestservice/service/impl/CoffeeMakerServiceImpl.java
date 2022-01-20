package ru.trofimom.coffeemakerrestservice.service.impl;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import ru.trofimom.coffeemakerrestservice.model.CoffeeMaker;
import ru.trofimom.coffeemakerrestservice.model.Parameters;
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

        coffeeMaker = new CoffeeMaker(
                coffeeMaker.getWaterTemperature(),
                coffeeMaker.getHardWater(),
                coffeeMaker.getRemainingCupsBeforeCleaning() - cups * coffeeMaker.getHardWater());

        coffeeMakerRepository.save(coffeeMaker);

        return new ResultResponse("Start making coffee");
    }

    @Override
    public ResultResponse setParameters(Parameters parameters) {

        if (parameters.getHardWater() == 0 && parameters.getWaterTemperature() == 0)
            return new ResultResponse("No data to save");
        if (parameters.getHardWater() < 1 || parameters.getHardWater() > 3)
            return new ResultResponse("Parameter 'hardWater' must be from 1 to 3");
        if (parameters.getWaterTemperature() < 1 || parameters.getWaterTemperature() > 3)
            return new ResultResponse("Parameter 'waterTemperature' must be from 1 to 3");

        CoffeeMaker coffeeMaker = coffeeMakerRepository.findTopByOrderByIdDesc();

        coffeeMaker = new CoffeeMaker(
                parameters.getWaterTemperature() == 0 ? coffeeMaker.getWaterTemperature() : parameters.getWaterTemperature(),
                parameters.getHardWater() == 0 ? coffeeMaker.getHardWater() : parameters.getHardWater(),
                coffeeMaker.getRemainingCupsBeforeCleaning());

        coffeeMakerRepository.save(coffeeMaker);

        return new ResultResponse("Parameters saved");
    }

    @Override
    public ResultResponse showCondition() {
        return new ResultResponse(coffeeMakerRepository.findTopByOrderByIdDesc());
    }

    @Override
    public ResultResponse cleaning() {
        CoffeeMaker coffeeMaker = coffeeMakerRepository.findTopByOrderByIdDesc();

        coffeeMaker = new CoffeeMaker(
                coffeeMaker.getWaterTemperature(),
                coffeeMaker.getHardWater(),
                totalCupsBeforeCleaning);


        coffeeMakerRepository.save(coffeeMaker);

        return new ResultResponse("Start cleaning");
    }
}
