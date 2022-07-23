package com.homework.JdbcApp.model;

import com.sun.istack.NotNull;
import lombok.Data;
import org.springframework.data.annotation.Id;

@Data
public class Address {
    @Id
    private long id;
    @NotNull
    private String country;
    @NotNull
    private String city;
    @NotNull
    private String street;
    private long idPerson;

    public Address(long id, String country, String city, String street,long idPerson) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.street = street;
        this.idPerson = idPerson;
    }

    @Override
    public String toString() {
        return "Address{" +
                "country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", street='" + street + '\'' +
                '}';
    }
}
