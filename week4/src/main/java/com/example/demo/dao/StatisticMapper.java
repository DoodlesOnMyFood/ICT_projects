package com.example.demo.dao;

import com.example.demo.dto.StatisticDTO;
import org.apache.ibatis.annotations.Select;


import java.util.Map;

public interface StatisticMapper {
    public StatisticDTO selectYearLogin(String year);
    public StatisticDTO selectYearMonthLogin(String year, String month);
    public StatisticDTO selectYearMonthDayLogin(String year, String month, String day);
    public Map<String, String> getDailyCounts();
    public StatisticDTO selectCountNotDaysOff();
    public StatisticDTO selectYearMonthDepartment(String yearMonth, String department);
}
