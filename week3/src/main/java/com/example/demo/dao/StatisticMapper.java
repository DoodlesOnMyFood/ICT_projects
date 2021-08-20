package com.example.demo.dao;

import org.apache.ibatis.annotations.Select;

import java.util.HashMap;

public interface StatisticMapper {
    public HashMap<String, Object> selectYearLogin(String year);
}
