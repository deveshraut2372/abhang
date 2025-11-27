package com.devesh.abhang.dto.Res;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FileResponce {

    private String format;

    private String publicId;

    private String url;

    private String secureUrl;


}
