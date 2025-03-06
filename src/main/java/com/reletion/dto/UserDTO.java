package com.reletion.dto;

import lombok.*;

@Data
public class UserDTO {
    private Long id;
    private String name;
    private String email;
    private ProfileDTO profile;
      
}

