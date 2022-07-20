package com.homework.InsuranceApp.model;

import com.homework.InsuranceApp.model.interfaces.Insurance;
import com.homework.InsuranceApp.validator.interfaces.BuildingYearConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@ToString
public class HouseInsurance implements Insurance {
    @Value("${price_per_room}")
    private static float pricePerRoom;
    @Value("${house_reduction_price_per_year}")
    private static float houseReductionPricePerYear;

    @NotNull
    private String address;
    @BuildingYearConstraint
    @Min(0)
    private int buildingYear;
    @Min(1)
    private int numberOfRooms;

    public HouseInsurance(String address, int buildingYear, int numberOfRooms) {
        this.address = address;
        this.buildingYear = buildingYear;
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public double getPrice() {
        return numberOfRooms*pricePerRoom
                - houseReductionPricePerYear*(LocalDateTime.now().getYear()-buildingYear);
    }
}
