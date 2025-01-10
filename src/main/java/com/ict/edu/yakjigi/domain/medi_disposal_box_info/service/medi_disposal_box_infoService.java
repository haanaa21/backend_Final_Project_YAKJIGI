package com.ict.edu.yakjigi.domain.medi_disposal_box_info.service;

import java.util.List;

import com.ict.edu.yakjigi.domain.medi_disposal_box_info.vo.medi_disposal_box_infoVO;

public interface medi_disposal_box_infoService {
    List<String> getCities();
    List<String> getTowns(String city);
    List<medi_disposal_box_infoVO> getCityCoordinates(String city, String town, String keyword);
    List<medi_disposal_box_infoVO> getCityCoordinatesByCityOnly(String city);
    List<medi_disposal_box_infoVO> getCityCoordinatesByKeywordOnly(String keyword);
}
