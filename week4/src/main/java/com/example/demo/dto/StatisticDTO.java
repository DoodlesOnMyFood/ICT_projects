package com.example.demo.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@Data
public class StatisticDTO {
    private String value;
    private List<ErrorDTO> errors;
    private Boolean hasErrors;
    private String input;

    public StatisticDTO() {
        errors = new ArrayList<>();
    }
}
