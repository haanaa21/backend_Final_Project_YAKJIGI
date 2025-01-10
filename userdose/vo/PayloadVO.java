package com.ict.edu.yakjigi.domain.userdose.vo;

import java.time.LocalDate;
import java.util.List;

import lombok.Data;

@Data
public class PayloadVO {
    private int user_idx;
    private LocalDate dose_date;
    private String dose_other;
    private List<Medication> medications;

    @Data
    public static class Medication {
        private String medi_name;
        private String dose_way;
        private String dose_purpose;
    }
}
