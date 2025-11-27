package com.devesh.abhang.dto.Req;

import lombok.*;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class UpdatePasswordReq {

    String newPassword;

    String userName;

}
