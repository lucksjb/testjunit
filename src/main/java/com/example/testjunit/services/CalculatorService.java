package com.example.testjunit.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CalculatorService {
    @Autowired
    private OperationsService operationsService;

    public int add(int a, int b) {
        operationsService.sendMessage(String.format("add %d + %d",a,b));
        return a + b;
    }

    public int minus(int a, int b) {
        operationsService.sendMessage(String.format("minus %d + %d",a,b));
        return a - b;
    }

    public int multiply(int a, int b) {
        operationsService.sendMessage(String.format("multiply %d + %d",a,b));
        return a * b;
    }

    public Double divide(int a, int b) {
        operationsService.sendMessage(String.format("divide %d + %d",a,b));
        return (double) (a / b);
    }

    public Double addOneOnValueAndDivideByTwo(int a) {
        int result = operationsService.addOneOnValue(a);
        return (double) (result / 2);
    }
}
