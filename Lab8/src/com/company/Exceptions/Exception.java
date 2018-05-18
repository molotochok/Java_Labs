package com.company.Exceptions;

public class Exception extends Throwable{

    protected String message;;

    public Exception() {
        super();
    }
    public Exception(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return getMessage();
    }

    public String getMessage(){
        return message;
    }
}
