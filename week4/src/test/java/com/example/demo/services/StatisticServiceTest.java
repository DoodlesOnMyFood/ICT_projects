package com.example.demo.services;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.text.ParseException;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class StatisticServiceTest {
    @Autowired
    StatisticService service;

    @Test
    void testService() throws ParseException {
        System.out.println(service.getDailyAverage());
    }
}


