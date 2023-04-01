package com.learning.api.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = NationalityCheckValidator.class)
public @interface NationalityCheck {

    String message() default "Invalid nationality: It should be either US Or Canada";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };

}
