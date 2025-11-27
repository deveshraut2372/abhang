package com.devesh.abhang.ExceptionHandling.Exceptions;


public class UnauthorizeAccess extends RuntimeException{

    String message;

    public UnauthorizeAccess(String message) {
        super(message);
        this.message = message;
    }



}
