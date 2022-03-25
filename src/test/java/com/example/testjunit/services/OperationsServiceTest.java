package com.example.testjunit.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

// import org.junit.Test; 
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@DisplayName("Teste unitário OperationsService")
public class OperationsServiceTest {
    @Autowired
    private OperationsService operationsService;

    @Test
    @DisplayName("deve retornar o valor passado como parametros acrescido de 1 ")
    public void deve_retornar_o_valor_mais_um() {
        Double result = operationsService.addOneOnValue(10d);
        assertEquals(11, result);
    }

    
}
