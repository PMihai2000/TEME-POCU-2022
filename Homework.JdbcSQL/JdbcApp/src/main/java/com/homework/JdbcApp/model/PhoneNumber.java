package com.homework.JdbcApp.model;

import com.sun.istack.NotNull;
import lombok.Data;
import javax.persistence.Id;

@Data
public class PhoneNumber {
    @Id
    private long id;
    @NotNull
    private String number;
    @NotNull
    private String service_provider;
    private long idPerson;

    public PhoneNumber(long id, String number, String service_provider,long idPerson) {
        this.id = id;
        this.number = number;
        this.service_provider = service_provider;
        this.idPerson = idPerson;
    }

    @Override
    public String toString() {
        return "PhoneNumber{" +
                "number='" + number + '\'' +
                ", service_provider='" + service_provider + '\'' +
                '}';
    }
}
