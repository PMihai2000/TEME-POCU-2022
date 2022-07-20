package com.homework.InsuranceApp.validator.interfaces;

import com.homework.InsuranceApp.validator.PhoneNumberConstraintValidator;
import com.homework.InsuranceApp.validator.YearOfFabricationConstraintValidator;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = YearOfFabricationConstraintValidator.class)
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD,ElementType.FIELD})
public @interface YearOfFabricationConstraint {
    String message() default "Invalid year of fabrication.";

    Class<?>[] groups() default{};

    Class<? extends Payload>[] payload() default{};
}
