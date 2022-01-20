package ru.trofimom.coffeemakerrestservice.service;

import ru.trofimom.coffeemakerrestservice.model.Parameters;
import ru.trofimom.coffeemakerrestservice.response.ResultResponse;

public interface CoffeeMakerService {

    ResultResponse makeCoffee(int cups);

    ResultResponse setParameters(Parameters parameters);

    ResultResponse showCondition();

    ResultResponse cleaning();
}
