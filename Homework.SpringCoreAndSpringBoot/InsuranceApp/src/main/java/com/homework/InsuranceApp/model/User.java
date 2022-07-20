package com.homework.InsuranceApp.model;

import com.homework.InsuranceApp.validator.interfaces.PhoneNumberConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@ToString
public class User {
    private String lastname;
    private String firstname;
    @PhoneNumberConstraint
    private String phoneNumber;

    public User(String lastname, String firstname, String phoneNumber) {
        this.lastname = lastname;
        this.firstname = firstname;
        this.phoneNumber = phoneNumber;
    }
}
