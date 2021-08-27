package com.example.demo.controllers;



import com.example.demo.dto.StatisticDTO;
import com.example.demo.services.StatisticService;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.springframework.http.MediaType;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping("/api/statistics/")
public class Test {


    private StatisticService service;

    public Test(StatisticService service) {
        this.service = service;
    }

    @GetMapping("/{year}")
    StatisticDTO getYear(@PathVariable String year, Model model){
        return service.getYearLoginNum(year);
    }


    @GetMapping("/monthly/{yearMonth}")
    StatisticDTO getYearMonth(@PathVariable String yearMonth){
        return service.getYearMonthLoginNum(yearMonth);
    }

    @GetMapping("/daily/{yearMonthDay}")
    StatisticDTO getYearMonthDay(@PathVariable String yearMonthDay){
        return service.getYearMonthDayLoginNum(yearMonthDay);
    }

    @GetMapping("/average")
    StatisticDTO getAverage() throws ParseException {
        return service.getDailyAverage();
    }


    @GetMapping("/workdays")
    StatisticDTO getWorkdaysLogins(){
        return service.getLoginsOnWorkdays();
    }

    @GetMapping("/{department}/monthly/{yearMonth}")
    StatisticDTO getYearMonthDepartment(@PathVariable String department, @PathVariable String yearMonth){
        return service.getYearMonthDepartmentLoginNum(yearMonth, department);
    }


    @GetMapping(value = "/test", produces = MediaType.APPLICATION_JSON_VALUE)
    List<String> test(Model model){
        System.out.println("wtf?");


        List<String> list =  new ArrayList<>();
        list.add("!!!HELLO WORLD!!!");
        list.add("설정 TEST!!!");
        list.add("설정 TEST!!!");
        list.add("설정 TEST!!!!!");
        list.add("설정 TEST!!!!!!");


        return list;
    }
}
