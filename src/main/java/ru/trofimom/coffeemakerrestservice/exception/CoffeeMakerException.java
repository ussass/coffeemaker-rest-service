package ru.trofimom.coffeemakerrestservice.exception;

public class CoffeeMakerException extends RuntimeException {

    public CoffeeMakerException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return super.getMessage();
    }

    @Override
    public String getLocalizedMessage() {
        return super.getLocalizedMessage();
    }

    @Override
    public void printStackTrace() {
        super.printStackTrace();
    }
}
