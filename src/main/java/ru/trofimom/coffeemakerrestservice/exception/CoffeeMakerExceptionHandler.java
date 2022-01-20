package ru.trofimom.coffeemakerrestservice.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import ru.trofimom.coffeemakerrestservice.response.ResultResponse;

@ControllerAdvice
public class CoffeeMakerExceptionHandler {

    @ExceptionHandler(ApplicationException.class)
    ResponseEntity<ResultResponse> invalidLoginOrPassword(ApplicationException e) {
        return handleInternal(HttpStatus.BAD_REQUEST, e.getLocalizedMessage());
    }

    private ResponseEntity<ResultResponse> handleInternal(HttpStatus status, String message) {
        return new ResponseEntity<>(new ResultResponse(message), status);
    }
}
