package com.example.testjunit.services;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doAnswer;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

@SpringBootTest
@DisplayName("This is a Calculadora test")
public class CalculatorServiceMockBeanTest {
    @MockBean
    private OperationsService operationsService;

    @Autowired
    private CalculatorService calculatorService;

    @Test
    @DisplayName("deve acrescentar um ao numero passado e dividir por dois")
    public void deve_acrescentar_um_ao_numero_passado_e_dividir_por_dois() {
        final int value = 11;
        Mockito.when(operationsService.addOneOnValue(value)).thenReturn(12);

        Double result = calculatorService.addOneOnValueAndDivideByTwo(value);
        assertEquals(6, result);
    }

    @Test
    @DisplayName("deve simular envio de mensagem no sqs ")
    public void deve_simular_envio_de_mensagem_no_sqs() {
         
        List<String> messagesSended = new ArrayList<>();
        doAnswer((answer) -> {
           messagesSended.add(answer.getArgument(0));
            return null;
        })
                .when(operationsService).sendMessage(any());

        calculatorService.add(10, 5);
        calculatorService.minus(10, 5);
        calculatorService.multiply(10, 5);
        calculatorService.divide(10, 5);

        messagesSended.forEach(p -> {
            System.out.println(p);
        });
        assertEquals(4, messagesSended.size());
        assertTrue(messagesSended.toString().contains("add"));
        assertTrue(messagesSended.toString().contains("minus"));
        assertTrue(messagesSended.toString().contains("multiply"));
        assertTrue(messagesSended.toString().contains("divide"));
    }

}
