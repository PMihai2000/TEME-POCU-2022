package com.homework.InsuranceApp.model;

import com.homework.InsuranceApp.model.interfaces.Insurance;
import com.homework.InsuranceApp.validator.interfaces.BuildingYearConstraint;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.Objects;


@Configuration
@PropertySource("classpath:application.properties")
@Data
@NoArgsConstructor
@ToString
public class HouseInsurance extends Insurance {

    private static float PRICE_PER_ROOM;
    @Value("${price_per_room}")
    public void setPricePerRoom(float value){
        PRICE_PER_ROOM = value;
    }

    private static float HOUSE_REDUCTION_PRICE_PER_YEAR;
    @Value("${house_reduction_price_per_year}")
    public void setHouseReductionPricePerYear(float value){
        HOUSE_REDUCTION_PRICE_PER_YEAR = value;
    }

    private static long ID_HOUSE_INSURANCE = 0;

    @Id
    private long id;
    @NotNull
    private String address;
    @BuildingYearConstraint
    @Min(0)
    private int buildingYear;
    @Min(1)
    private int numberOfRooms;

    public HouseInsurance(String address, int buildingYear, int numberOfRooms) {
        this.id = ID_HOUSE_INSURANCE++;
        this.address = address;
        this.buildingYear = buildingYear;
        this.numberOfRooms = numberOfRooms;
    }

    @Override
    public double getPrice() {
        return numberOfRooms* PRICE_PER_ROOM
                - HOUSE_REDUCTION_PRICE_PER_YEAR *(LocalDateTime.now().getYear()-buildingYear);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        HouseInsurance that = (HouseInsurance) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
