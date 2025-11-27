package com.devesh.abhang.ExceptionHandling;

import java.time.LocalDateTime;

public class ExceptionRes {

    String message;

    String responseCode;

    LocalDateTime timeStamp;

    String URL;

    public ExceptionRes(String message, String responseCode, LocalDateTime timeStamp,String url) {
        this.message = message;
        this.responseCode = responseCode;
        this.timeStamp = timeStamp;
        this.URL= url;
    }
}
