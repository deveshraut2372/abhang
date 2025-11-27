package com.devesh.abhang.entity;

import lombok.*;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;

@Data
@Document(collection = "mainMaster")
@Getter
@Setter
public class MainMaster {

    @Id
    private String mainId;

    private String name;

    private String type;

    private String status;

    @CreatedDate
    private LocalDate createdDate;

    public MainMaster() {
    }

    public MainMaster(String mainId, String name, String type, String status, LocalDate createdDate) {
        this.mainId = mainId;
        this.name = name;
        this.type = type;
        this.status = status;
        this.createdDate = createdDate;
    }

    public String getMainId() {
        return mainId;
    }

    public void setMainId(String mainId) {
        this.mainId = mainId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }
}
