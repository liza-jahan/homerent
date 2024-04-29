package com.example.homerent.model;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResetPasswordResponse {
    private String currentPassword;
    private  String newPassword;
}
