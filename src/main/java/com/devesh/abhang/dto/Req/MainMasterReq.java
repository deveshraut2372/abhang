package com.devesh.abhang.dto.Req;


import lombok.*;

import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class MainMasterReq {

    private String mainId;

    private String name;

    private String type;

    private String status;

    private LocalDate createdDate;


}
