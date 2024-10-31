package io.github.leandrotominay.quarkusmediasocial.rest.dto;

import lombok.Data;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;


@Data
public class CreateUserRequest {


    @NotBlank(message = "Name is required") // Hibernate Validator
    private String name;
    @NotNull(message = "Age is required")
    private Integer age;


}
