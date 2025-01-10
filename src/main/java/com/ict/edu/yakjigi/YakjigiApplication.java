package com.ict.edu.yakjigi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.ict.edu.yakjigi.domain.medi_disposal_box_info.mapper", 
             "com.ict.edu.yakjigi.domain.userdose.mapper", 
             "com.ict.edu.yakjigi.domain.counsel.mapper"})
public class YakjigiApplication {
    public static void main(String[] args) {
        SpringApplication.run(YakjigiApplication.class, args);
    }
}
