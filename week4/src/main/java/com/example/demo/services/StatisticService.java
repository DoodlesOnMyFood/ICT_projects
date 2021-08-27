package com.example.demo.services;

import com.example.demo.dto.StatisticDTO;

import java.text.ParseException;
import java.util.HashMap;

public interface StatisticService {
    public StatisticDTO getYearLoginNum(String year);
    public StatisticDTO getYearMonthLoginNum(String yearMonth);
    public StatisticDTO getYearMonthDayLoginNum(String yearMonthDay);
    public StatisticDTO getDailyAverage() throws ParseException;
    public StatisticDTO getLoginsOnWorkdays();
    public StatisticDTO getYearMonthDepartmentLoginNum(String yearMonth, String department);
}
