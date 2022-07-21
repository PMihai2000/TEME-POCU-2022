package com.homework.InsuranceApp.model.interfaces;

import javax.persistence.Id;

public abstract class Insurance {
    @Id
    protected long id;

    public long getId() {
        return id;
    }

    public double getPrice() {return 0.0f;}
}
