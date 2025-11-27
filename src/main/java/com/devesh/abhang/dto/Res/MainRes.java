package com.devesh.abhang.dto.Res;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
public class MainRes {

    private Boolean flag;

    private String message;

    private String responceCode;

    private LocalDateTime timeStamp;

    public MainRes(Boolean flag, String message, String responceCode, LocalDateTime timeStamp) {
        this.flag = flag;
        this.message = message;
        this.responceCode = responceCode;
        this.timeStamp = timeStamp;
    }

    public MainRes() {
    }

    public Boolean getFlag() {
        return flag;
    }

    public void setFlag(Boolean flag) {
        this.flag = flag;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getResponceCode() {
        return responceCode;
    }

    public void setResponceCode(String responceCode) {
        this.responceCode = responceCode;
    }

    public LocalDateTime getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(LocalDateTime timeStamp) {
        this.timeStamp = timeStamp;
    }
}

