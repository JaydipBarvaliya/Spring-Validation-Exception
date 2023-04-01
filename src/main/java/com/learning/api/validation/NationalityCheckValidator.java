package com.learning.api.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

import java.util.Arrays;
import java.util.List;

public class NationalityCheckValidator implements ConstraintValidator<NationalityCheck, String> {

    @Override
    public boolean isValid(String nationality, ConstraintValidatorContext context) {

        List<String> nationalityTypes = Arrays.asList("US", "Canada");
        return nationalityTypes.contains(nationality);
    }
}
