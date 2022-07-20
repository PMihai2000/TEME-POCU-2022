package com.homework.InsuranceApp.controller;


import com.homework.InsuranceApp.model.CarInsurance;
import com.homework.InsuranceApp.model.HouseInsurance;
import com.homework.InsuranceApp.model.interfaces.Insurance;
import com.homework.InsuranceApp.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/insurances/cars")
@RequiredArgsConstructor
public class CarInsuranceController {
    private final InsuranceService insuranceService;

    @PostMapping
    public Insurance createCarInsurance(@Valid @RequestBody CarInsurance insurance){return insuranceService.createInsurance(insurance);}
    @GetMapping
    public double getCarInsurancePrice(@Valid @RequestBody CarInsurance insurance){return insuranceService.getInsurancePrice(insurance);}
}
