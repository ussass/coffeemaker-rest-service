package ru.trofimom.coffeemakerrestservice.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import ru.trofimom.coffeemakerrestservice.model.CoffeeMaker;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class ResultResponse {

    private String message;

    private CoffeeMaker coffeeMaker;

    public ResultResponse(String message) {
        this.message = message;
    }

    public ResultResponse(CoffeeMaker coffeeMaker) {
        this.coffeeMaker = coffeeMaker;
    }

    public String getMessage() {
        return message;
    }

    public CoffeeMaker getCoffeeMaker() {
        return coffeeMaker;
    }
}
