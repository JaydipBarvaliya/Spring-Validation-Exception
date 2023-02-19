package com.learning.api.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "USER_TBL")
@Data
@NoArgsConstructor
@AllArgsConstructor(staticName = "build")
public class User {

    @Id
    @GeneratedValue
    private int userId;

    @NotNull(message = "username should not be null")
    private String name;

    @Email(message = "Invalid email Address")
    private String email;

    @Pattern(regexp = "^\\d{10}$", message = "Invalid mobile number entered.")
    private String mobile;

    private String gender;
    @Min(18)
    @Max(60)
    private int age;
    @NotBlank
    private String nationality;


}
