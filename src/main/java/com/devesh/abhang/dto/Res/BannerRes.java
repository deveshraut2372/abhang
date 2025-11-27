package com.devesh.abhang.dto.Res;

import lombok.*;

import java.time.LocalDate;

@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BannerRes {

    private String bannerId;

    private String bannerImage;

    private String status;

    private LocalDate createdDate;

}
