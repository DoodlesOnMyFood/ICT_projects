package com.example.demo.services;

import com.example.demo.dao.StatisticMapper;
import org.springframework.stereotype.Service;

import java.util.HashMap;

@Service
public class StatisticServiceImpl implements StatisticService {
    private StatisticMapper mapper;

    public StatisticServiceImpl(StatisticMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public HashMap<String, Object> yearLoginNum(String year) {
        HashMap<String, Object> map = new HashMap<>();

        try{
            map = mapper.selectYearLogin(year);
            map.put("year", year);
            map.put("is_sucess", true);
        } catch (Exception e){
            System.out.println(e.getMessage());
            map.put("totCnt", -999);
            map.put("year", year);
            map.put("is_success", false);
        }

        return map;
    }
}
