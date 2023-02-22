package com.learning.api.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class UserRequestDTO {

    private String name;
    private String email;
    private String mobile;
    private String gender;
    private int age;
    private String nationality;
}
