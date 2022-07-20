package com.homework.InsuranceApp.validator;

import com.homework.InsuranceApp.validator.interfaces.YearOfFabricationConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.time.LocalDateTime;

public class YearOfFabricationConstraintValidator implements ConstraintValidator<YearOfFabricationConstraint,Integer> {

    @Override
    public void initialize(YearOfFabricationConstraint constraintAnnotation) {
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(Integer yearOfFabrication, ConstraintValidatorContext ctx) {
        return LocalDateTime.now().getYear()>=yearOfFabrication;
    }
}
