package com.ict.edu.yakjigi;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan({"com.ict.edu.yakjigi.domain.Sub303.mapper", 
             "com.ict.edu.yakjigi.domain.Mybasicboardlog.mapper", 
             "com.ict.edu.yakjigi.domain.counsel.mapper"})
public class YakjigiApplication {
    public static void main(String[] args) {
        SpringApplication.run(YakjigiApplication.class, args);
        System.out.println("Requesting image from URL: https://nedrug.mfds.go.kr/pbp/cmn/itemImageDownload/147426403087300104");
    }
}
