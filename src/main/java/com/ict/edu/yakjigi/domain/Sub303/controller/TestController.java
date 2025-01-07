package com.ict.edu.yakjigi.domain.Sub303.controller;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // React와 통신 허용
public class TestController {

    @GetMapping("/api/test")
    public String testConnection() {
        return "Spring Boot 연결 성공!";
    }
}

