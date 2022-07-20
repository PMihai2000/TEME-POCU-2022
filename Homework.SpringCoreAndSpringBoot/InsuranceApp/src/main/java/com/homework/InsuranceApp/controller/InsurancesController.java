package com.homework.InsuranceApp.controller;

import com.homework.InsuranceApp.model.interfaces.Insurance;
import com.homework.InsuranceApp.service.InsuranceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/insurances")
@RequiredArgsConstructor
public class InsurancesController {
    private final InsuranceService insuranceService;

    @GetMapping
    public List<Insurance> getInsurances(){return insuranceService.findAll();}
}
