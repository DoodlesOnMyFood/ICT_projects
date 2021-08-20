package com.example.demo.controllers;



import com.example.demo.services.StatisticService;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
public class Test {


    private StatisticService service;

    public Test(StatisticService service) {
        this.service = service;
    }

    @GetMapping("/sqlyearStatistic")
    @ResponseBody
    Map<String, Object> sqlTest(@RequestParam String year, Model model){
        return service.yearLoginNum(year);
    }


    @GetMapping("/test")
    String test(Model model){
        System.out.println("wtf?");

        model.addAttribute("name", "test name");
        List<String> list =  new ArrayList<>();
        list.add("!!!HELLO WORLD!!!");
        list.add("설정 TEST!!!");
        list.add("설정 TEST!!!");
        list.add("설정 TEST!!!!!");
        list.add("설정 TEST!!!!!!");
        model.addAttribute("list", list);

        return "test";
    }
}
