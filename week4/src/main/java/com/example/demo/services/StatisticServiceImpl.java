package com.example.demo.services;

import com.example.demo.dao.StatisticMapper;
import com.example.demo.dto.ErrorDTO;
import com.example.demo.dto.StatisticDTO;
import org.springframework.stereotype.Service;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@Service
public class StatisticServiceImpl implements StatisticService {
    private StatisticMapper mapper;

    public StatisticServiceImpl(StatisticMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public StatisticDTO getYearLoginNum(String year) {
        StatisticDTO statisticDTO = new StatisticDTO();

        try{
            statisticDTO = mapper.selectYearLogin(year);
            statisticDTO.setInput(year);
            statisticDTO.setHasErrors(false);
        } catch (Exception e){
            System.out.println(e.getMessage());
            statisticDTO.setValue("" +-999L);
            statisticDTO.setInput(year);
            statisticDTO.setHasErrors(true);
            ErrorDTO errorDTO = new ErrorDTO(e.getMessage());
            statisticDTO.getErrors().add(errorDTO);
        }

        return statisticDTO;
    }

    @Override
    public StatisticDTO getYearMonthLoginNum(String yearMonth) {
        StatisticDTO statisticDTO = null;
        try{
            System.out.println("try?");
            verify(4, yearMonth);
        } catch (Exception e) {
            statisticDTO = new StatisticDTO();
            statisticDTO.getErrors().add(new ErrorDTO(e.getMessage()));
            statisticDTO.setValue("" + -999L);
            statisticDTO.setInput(yearMonth);
            return statisticDTO;
        }


        String year = yearMonth.substring(0,2);
        String month = yearMonth.substring(2,4);


        try{
            statisticDTO = mapper.selectYearMonthLogin(year, month);
            statisticDTO.setHasErrors(false);
        } catch (Exception e){
            statisticDTO.setValue("" + -999L);
            statisticDTO.setHasErrors(true);
            statisticDTO.getErrors().add(new ErrorDTO(e.getMessage()));
        }
        statisticDTO.setInput(yearMonth);
        return statisticDTO;
    }

    @Override
    public StatisticDTO getYearMonthDayLoginNum(String yearMonthDay) {
        StatisticDTO statisticDTO = null;
        try{
            verify(6, yearMonthDay);
        } catch (Exception e) {
            statisticDTO = new StatisticDTO();
            statisticDTO.getErrors().add(new ErrorDTO(e.getMessage()));
            statisticDTO.setValue("" + -999L);
            statisticDTO.setInput(yearMonthDay);
            return statisticDTO;
        }

        String year = yearMonthDay.substring(0, 2);
        String month = yearMonthDay.substring(2,4);
        String day = yearMonthDay.substring(4,6);

        try{
            statisticDTO = mapper.selectYearMonthDayLogin(year, month, day);
            statisticDTO.setHasErrors(false);
        } catch (Exception e){
            statisticDTO.setValue("" + -999L);
            statisticDTO.setHasErrors(true);
            statisticDTO.getErrors().add(new ErrorDTO(e.getMessage()));
        }
        statisticDTO.setInput(yearMonthDay);
        return statisticDTO;
    }

    @Override
    public StatisticDTO getDailyAverage() throws ParseException {

        StatisticDTO statisticDTO = new StatisticDTO();
        statisticDTO.setInput("");
        Map<String, String> dates = mapper.getDailyCounts();
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        Date today = format.parse(dates.get("today"));
        Date first = format.parse(dates.get("first"));
        System.out.println(dates.get("value"));
        Long value = Long.valueOf(dates.get("value"));
        long diffMilli = today.getTime() - first.getTime();
        Long diff = TimeUnit.DAYS.convert(diffMilli, TimeUnit.MILLISECONDS);

        statisticDTO.setValue(""+ ((double) value / (double)diff));

        return statisticDTO;
    }

    @Override
    public StatisticDTO getLoginsOnWorkdays() {
        StatisticDTO statisticDTO = mapper.selectCountNotDaysOff();
        statisticDTO.setInput("");
        return statisticDTO;
    }


    @Override
    public StatisticDTO getYearMonthDepartmentLoginNum(String yearMonth, String department) {
        StatisticDTO statisticDTO = null;
        try{
            verify(4, yearMonth);
        } catch (Exception e) {
            statisticDTO = new StatisticDTO();
            statisticDTO.getErrors().add(new ErrorDTO(e.getMessage()));
            statisticDTO.setValue("" + -999L);
            statisticDTO.setInput("yearMonth : " + yearMonth + ", department : " + department );
            return statisticDTO;
        }


        try{
            statisticDTO = mapper.selectYearMonthDepartment(yearMonth, department);
            statisticDTO.setHasErrors(false);
        } catch (Exception e){
            statisticDTO = new StatisticDTO();
            statisticDTO.getErrors().add(new ErrorDTO(e.getMessage()));
            statisticDTO.setValue("" + -999L);
        }



        return statisticDTO;
    }


    private void verify(int length, String input) throws Exception {
        if((input.length() != length) || !input.matches("^[0-9]*$"))
            throw new Exception("Invalid input.");
    }
}

