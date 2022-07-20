package com.homework.InsuranceApp.model;


import com.homework.InsuranceApp.model.interfaces.Insurance;
import com.homework.InsuranceApp.validator.interfaces.YearOfFabricationConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString
public class CarInsurance implements Insurance {

    @Value("${car_depreciation_value:5.0}")
    private static float depreciationValue;
    @Value("${price_per_power_unit:10.0}")
    private static float pricePerPowerUnit;

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
        this.manufacturer = manufacturer;
        this.model = model;
        this.yearOfFabrication = yearOfFabrication;
        this.power = power;
    }

    @Override
    public double getPrice() {
        return pricePerPowerUnit*power
                - (LocalDateTime.now().getYear()-yearOfFabrication)*depreciationValue;
    }
}
