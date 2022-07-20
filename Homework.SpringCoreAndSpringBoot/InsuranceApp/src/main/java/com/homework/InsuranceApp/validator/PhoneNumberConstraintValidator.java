package com.homework.InsuranceApp.validator;

import com.homework.InsuranceApp.validator.interfaces.PhoneNumberConstraint;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

public class PhoneNumberConstraintValidator implements
        ConstraintValidator<PhoneNumberConstraint,String>{
    @Override
    public void initialize(PhoneNumberConstraint constraintAnnotation){
        ConstraintValidator.super.initialize(constraintAnnotation);
    }

    @Override
    public boolean isValid(String phoneNumberContactField, ConstraintValidatorContext ctx) {
        return phoneNumberContactField !=null && phoneNumberContactField.matches("[0-9]+")
                &&(phoneNumberContactField.length()>8) && (phoneNumberContactField.length()<11);
    }
}
