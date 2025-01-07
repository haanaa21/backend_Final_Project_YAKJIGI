package com.ict.edu.yakjigi.domain.Mybasicboardlog.vo;

import java.time.LocalDate;

import lombok.Data;

@Data
public class MybasicboardlogVO {
    private int dose_idx;
    private int user_idx;
    private LocalDate dose_date;
    private String medi_name;
    private String dose_way;
    private String dose_purpose;
    private String dose_other;
    private String dose_photo;
}

