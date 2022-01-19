package ru.trofimom.coffeemakerrestservice.response;

public class ResultResponse {

   private String message;

    public ResultResponse(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
