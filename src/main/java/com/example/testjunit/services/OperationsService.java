package com.example.testjunit.services;

import org.springframework.stereotype.Service;

@Service
public class OperationsService {
    public int addOneOnValue(int value) {
        int result = value+1;
        return result;
    }

    public void sendMessage(String message) {
        System.out.println(String.format("Message %s sended ", message));
    }
}
