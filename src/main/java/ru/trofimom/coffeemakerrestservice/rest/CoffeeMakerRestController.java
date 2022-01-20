package ru.trofimom.coffeemakerrestservice.rest;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import ru.trofimom.coffeemakerrestservice.model.Parameters;
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
    @Operation(summary = "Make coffee")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "coffee has started to be made or a warning that there is no water")})
    public ResponseEntity<ResultResponse> makeCoffee(@RequestParam(defaultValue = "1") Integer cups) {
        return ResponseEntity.ok(coffeeMakerService.makeCoffee(cups));
    }

    @Operation(summary = "Set parameters")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Data saved successfully"),
            @ApiResponse(responseCode = "400", description = "Error in request body")})
    @PostMapping("/set")
    public ResponseEntity<ResultResponse> setParameters(@RequestBody Parameters parameters) {
        return ResponseEntity.ok(coffeeMakerService.setParameters(parameters));
    }

    @Operation(summary = "Show condition")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Shows the conditions of the coffee maker")})
    @GetMapping("/condition")
    public ResponseEntity<ResultResponse> showCondition() {
        return ResponseEntity.ok(coffeeMakerService.showCondition());
    }

    @Operation(summary = "Cleaning")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Starts descaling the coffee maker")})
    @GetMapping("/cleaning")
    public ResponseEntity<ResultResponse> cleaning() {
        return ResponseEntity.ok(coffeeMakerService.cleaning());
    }
}
