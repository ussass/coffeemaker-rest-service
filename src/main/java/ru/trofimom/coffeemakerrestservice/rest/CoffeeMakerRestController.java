package ru.trofimom.coffeemakerrestservice.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import ru.trofimom.coffeemakerrestservice.response.ResultResponse;
import ru.trofimom.coffeemakerrestservice.service.CoffeeMakerService;

@RestController
@RequestMapping("/api/v1/coffeemaker")
public class CoffeeMakerRestController {

    private final CoffeeMakerService coffeeMakerService;

    public CoffeeMakerRestController(CoffeeMakerService coffeeMakerService) {
        this.coffeeMakerService = coffeeMakerService;
    }

    @GetMapping
    public ResponseEntity<ResultResponse> makeCoffee(){
        return ResponseEntity.ok(coffeeMakerService.makeCoffee());
    }

    @GetMapping("/set")
    public ResponseEntity<Boolean> setOptions(@RequestParam(required = false) Integer waterTemperature,
                                              @RequestParam(required = false) Integer hardWater){
        System.out.println("waterTemperature = " + waterTemperature);
        System.out.println("hardWater = " + hardWater);

        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
