package com.ict.edu.yakjigi.domain.Sub303.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.ict.edu.yakjigi.domain.Sub303.service.Sub303Service;
import com.ict.edu.yakjigi.domain.Sub303.vo.Sub303VO;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // React 개발 서버 URL
@RequestMapping("/api")
public class Sub303Controller {

    private final Sub303Service sub303Service;

    @Autowired
    public Sub303Controller(Sub303Service sub303Service) {
        this.sub303Service = sub303Service;
    }

    // 도시 목록 조회
    @GetMapping("/getCities")
    public List<String> getCities() {
        return sub303Service.getCities();
    }

    // 구/군 목록 조회
    @GetMapping("/getTowns")
    public List<String> getTowns(@RequestParam String city) {
        return sub303Service.getTowns(city);
    }

    // 도시 좌표 목록 조회 (도시, 구/군, 키워드)
    @GetMapping("/getCityCoordinates")
    public List<Sub303VO> getCityCoordinates(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String town,
            @RequestParam(required = false) String keyword) {

        // 키워드만 사용
        if ((city == null || city.isEmpty()) && (town == null || town.isEmpty()) && (keyword != null && !keyword.isEmpty())) {
            return sub303Service.getCityCoordinatesByKeywordOnly(keyword);
        }

        // 도시만 사용
        if ((town == null || town.isEmpty()) && (keyword == null || keyword.isEmpty())) {
            return sub303Service.getCityCoordinatesByCityOnly(city);
        }

        // 도시, 구/군, 키워드 사용
        return sub303Service.getCityCoordinates(city, town, keyword);
    }
}