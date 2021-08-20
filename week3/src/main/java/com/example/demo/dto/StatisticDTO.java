package com.example.demo.dto;

import lombok.Data;

@Data
public class StatisticDTO {
    private Long requestID;
    private String requestCode;
    private String userID;
    private String createDate;
}
