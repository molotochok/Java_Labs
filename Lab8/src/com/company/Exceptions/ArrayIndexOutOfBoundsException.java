package com.company.Exceptions;

public class ArrayIndexOutOfBoundsException extends Exception {
    private final String description = "Array index is out of range";

    public ArrayIndexOutOfBoundsException() {
        super("");
    }
    public ArrayIndexOutOfBoundsException(String message) {
        super(message);
    }

    @Override
    public String getMessage() {
        return description + '\n' + super.getMessage();
    }
}
