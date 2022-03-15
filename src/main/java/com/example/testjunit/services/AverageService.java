package com.example.testjunit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AverageService {
    @Autowired
    private CalculatorService calculatorService;
    
    public Double avarage(int a, int b) {
        int result = calculatorService.add(a, b);
        return calculatorService.divide(result,2);

    }
}
