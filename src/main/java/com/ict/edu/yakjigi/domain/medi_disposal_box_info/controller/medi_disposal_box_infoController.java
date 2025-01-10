package com.ict.edu.yakjigi.domain.medi_disposal_box_info.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.ict.edu.yakjigi.domain.medi_disposal_box_info.service.medi_disposal_box_infoService;
import com.ict.edu.yakjigi.domain.medi_disposal_box_info.vo.medi_disposal_box_infoVO;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000") // React 개발 서버 URL
@RequestMapping("/api")
public class medi_disposal_box_infoController {

    private final medi_disposal_box_infoService medi_disposal_box_infoService;

    @Autowired
    public medi_disposal_box_infoController(medi_disposal_box_infoService medi_disposal_box_infoService) {
        this.medi_disposal_box_infoService = medi_disposal_box_infoService;
    }

    // 도시 목록 조회
    @GetMapping("/getCities")
    public List<String> getCities() {
        return medi_disposal_box_infoService.getCities();
    }

    // 구/군 목록 조회
    @GetMapping("/getTowns")
    public List<String> getTowns(@RequestParam String city) {
        return medi_disposal_box_infoService.getTowns(city);
    }

    // 도시 좌표 목록 조회 (도시, 구/군, 키워드)
    @GetMapping("/getCityCoordinates")
    public List<medi_disposal_box_infoVO> getCityCoordinates(
            @RequestParam(required = false) String city,
            @RequestParam(required = false) String town,
            @RequestParam(required = false) String keyword) {

        // 키워드만 사용
        if ((city == null || city.isEmpty()) && (town == null || town.isEmpty()) && (keyword != null && !keyword.isEmpty())) {
            return medi_disposal_box_infoService.getCityCoordinatesByKeywordOnly(keyword);
        }

        // 도시만 사용
        if ((town == null || town.isEmpty()) && (keyword == null || keyword.isEmpty())) {
            return medi_disposal_box_infoService.getCityCoordinatesByCityOnly(city);
        }

        // 도시, 구/군, 키워드 사용
        return medi_disposal_box_infoService.getCityCoordinates(city, town, keyword);
    }
}