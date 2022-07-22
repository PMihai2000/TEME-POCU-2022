package com.homework.InsuranceApp.model;

import com.homework.InsuranceApp.validator.interfaces.PhoneNumberConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import java.util.Locale;
import java.util.Objects;

@Data
@NoArgsConstructor
@ToString
public class User {
    private static int USER_ID = 0;
    @Id
    private int id;
    @NotNull
    private String lastname;
    @NotNull
    private String firstname;
    @PhoneNumberConstraint
    private String phoneNumber;

    public String getUsername(){
        return firstname.toLowerCase()+"."+lastname.toLowerCase();
    }

    public User(String lastname, String firstname, String phoneNumber) {
        this.id = USER_ID++;
        this.lastname = lastname;
        this.firstname = firstname;
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return id == user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }


}
