package com.devesh.abhang.dto.Req;

import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class BannerReq {

    private String bannerId;

    private String bannerImage;

    private String status;

    private LocalDate createdDate;


}
