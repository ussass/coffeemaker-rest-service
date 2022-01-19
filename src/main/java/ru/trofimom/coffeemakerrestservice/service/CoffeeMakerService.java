package ru.trofimom.coffeemakerrestservice.service;

import ru.trofimom.coffeemakerrestservice.response.ResultResponse;

public interface CoffeeMakerService {

    ResultResponse makeCoffee(int cups);

    ResultResponse setParameters(Integer waterTemperature, Integer hardWater);

    ResultResponse showCondition();

    ResultResponse cleaning();
}
