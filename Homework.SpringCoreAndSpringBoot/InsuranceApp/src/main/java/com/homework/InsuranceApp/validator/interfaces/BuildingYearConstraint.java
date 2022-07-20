package com.homework.InsuranceApp.validator.interfaces;

import com.homework.InsuranceApp.validator.BuildingYearConstraintValidation;
import com.homework.InsuranceApp.validator.PhoneNumberConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = BuildingYearConstraintValidation.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
public @interface BuildingYearConstraint {
    String message() default "Invalid building year.";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};
}
