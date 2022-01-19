package ru.trofimom.coffeemakerrestservice.rest;

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
    public ResponseEntity<ResultResponse> makeCoffee(@RequestParam(defaultValue = "1") Integer cups){
        return ResponseEntity.ok(coffeeMakerService.makeCoffee(cups));
    }

    @GetMapping("/set")
    public ResponseEntity<ResultResponse> setParameters(@RequestParam(required = false) Integer waterTemperature,
                                              @RequestParam(required = false) Integer hardWater){
        return ResponseEntity.ok(coffeeMakerService.setParameters(waterTemperature, hardWater));
    }

    @GetMapping("/condition")
    public ResponseEntity<ResultResponse> showCondition(){
        return ResponseEntity.ok(coffeeMakerService.showCondition());
    }

    @GetMapping("/cleaning")
    public ResponseEntity<ResultResponse> cleaning(){
        return ResponseEntity.ok(coffeeMakerService.cleaning());
    }
}
