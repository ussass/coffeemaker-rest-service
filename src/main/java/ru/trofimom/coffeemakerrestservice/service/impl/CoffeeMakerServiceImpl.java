package ru.trofimom.coffeemakerrestservice.service.impl;

import org.springframework.stereotype.Service;
import ru.trofimom.coffeemakerrestservice.response.ResultResponse;
import ru.trofimom.coffeemakerrestservice.service.CoffeeMakerService;
import ru.trofimom.coffeemakerrestservice.service.ResourceCheckingService;

@Service
public class CoffeeMakerServiceImpl implements CoffeeMakerService {

    private final ResourceCheckingService resourceCheckingService;

    public CoffeeMakerServiceImpl(ResourceCheckingService resourceCheckingService) {
        this.resourceCheckingService = resourceCheckingService;
    }

    @Override
    public ResultResponse makeCoffee() {
        if (!resourceCheckingService.waterLevelCheck()){
            return new ResultResponse("Not water");
        }
        return new ResultResponse("Start making coffee");
    }
}
