package com.devesh.abhang.dto.Res;

import lombok.*;

import java.time.LocalDate;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MainMasterRes {

    private String mainId;

    private String name;

    private String type;

    private String status;

    private LocalDate createdDate;
}
