package com.company.Exceptions;

public class NullPointerException extends Exception {
    private final String description = "Null pointer exception";

    public NullPointerException() {
        super("");
    }
    public NullPointerException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return description + '\n' + super.getMessage();
    }
}
