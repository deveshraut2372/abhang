package com.devesh.abhang.entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document(collection = "banner_Master")
public class BannerMaster {

    @Id
    private String bannerId;

    private String bannerImage;

    private String status;

    private LocalDate createdDate;

}
