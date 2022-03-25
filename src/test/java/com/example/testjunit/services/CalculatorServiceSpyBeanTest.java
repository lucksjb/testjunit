package com.example.testjunit.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.doReturn;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.SpyBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@DisplayName("This is a Calculadora test")
@TestInstance(Lifecycle.PER_CLASS)

public class CalculatorServiceSpyBeanTest {
    private Long count = 0L;

    @Autowired
    private AverageService averageService;

    @SpyBean
    private CalculatorService calculatorServiceSpyed;

    @Test
    @DisplayName("deve calcular a média de 2 numeros")
    public void deve_calcular_a_media_de_dois_numeros() {
        doReturn(12d).when(calculatorServiceSpyed).add(10d, 2d);
        calculatorServiceSpyed.add(10d, 2d);

        Double result = averageService.avarage(11d, 2d);
        assertEquals(6.5d, result);

    }

    @BeforeEach
    public void antes_de_cada_teste() {
        count++;
        System.out.println("executado antes de cada teste  " + count);
    }

}
