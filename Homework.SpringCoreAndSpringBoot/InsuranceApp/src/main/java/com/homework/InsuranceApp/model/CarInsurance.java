package com.homework.InsuranceApp.model;


import com.homework.InsuranceApp.model.interfaces.Insurance;
import com.homework.InsuranceApp.validator.interfaces.YearOfFabricationConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;

@Configuration
@PropertySource("classpath:application.properties")
@Data
@NoArgsConstructor
@ToString
public class CarInsurance extends Insurance {
    private static float DEPRECIATION_VALUE;
    @Value("${car_depreciation_value}")
    public void setDEPRECIATION_VALUE(float value){
        DEPRECIATION_VALUE = value;
    }
    private static float PRICE_PER_POWER_UNIT;
    @Value("${price_per_power_unit}")
    public void setPRICE_PER_POWER_UNIT(float value){
        PRICE_PER_POWER_UNIT = value;
    }

    private static long ID_CAR_INSURANCE = 0;


    @NotBlank
    @NotNull
    private String manufacturer;
    @NotNull
    private String model;
    @YearOfFabricationConstraint
    @Min(0)
    private int yearOfFabrication;
    @Min(0)
    private double power;

    public CarInsurance(String manufacturer, String model, int yearOfFabrication, double power) {
        this.id = ID_CAR_INSURANCE++;
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearOfFabrication = yearOfFabrication;
        this.power = power;
    }

    @Override
    public double getPrice() {
        return PRICE_PER_POWER_UNIT *power
                - (LocalDateTime.now().getYear()-yearOfFabrication)* DEPRECIATION_VALUE;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarInsurance that = (CarInsurance) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
