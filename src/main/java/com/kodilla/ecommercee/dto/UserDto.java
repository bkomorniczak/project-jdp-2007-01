package com.kodilla.ecommercee.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class UserDto {
    private Long id;
    private String userName;
    private String userEmail;
    private String userPassword;
    private String status;
    private Long userKey;

    public UserDto(String userName, String userEmail, String userPassword, String status, Long userKey) {
        this.userName = userName;
        this.userEmail = userEmail;
        this.userPassword = userPassword;
        this.status = status;
        this.userKey = userKey;
    }

}
