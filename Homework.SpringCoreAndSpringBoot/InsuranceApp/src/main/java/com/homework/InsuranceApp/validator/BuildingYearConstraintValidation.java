package com.homework.InsuranceApp.validator;

import com.homework.InsuranceApp.validator.interfaces.BuildingYearConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDate;
import java.time.LocalDateTime;

public class BuildingYearConstraintValidation implements ConstraintValidator<BuildingYearConstraint,Integer> {
    @Override
    public void initialize(BuildingYearConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer buildingYear, ConstraintValidatorContext ctx) {
        return LocalDateTime.now().getYear()>=buildingYear;
    }
}
