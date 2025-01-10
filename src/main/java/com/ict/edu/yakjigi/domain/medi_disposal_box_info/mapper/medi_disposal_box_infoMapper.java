package com.ict.edu.yakjigi.domain.medi_disposal_box_info.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ict.edu.yakjigi.domain.medi_disposal_box_info.vo.medi_disposal_box_infoVO;

@Mapper
public interface medi_disposal_box_infoMapper {
    List<String> getCities();
    List<String> getTowns(@Param("city") String city);
    List<medi_disposal_box_infoVO> getCityCoordinates(
            @Param("city") String city,
            @Param("town") String town,
            @Param("keyword") String keyword);
    List<medi_disposal_box_infoVO> getCityCoordinatesByCityOnly(@Param("city") String city);
    List<medi_disposal_box_infoVO> getCityCoordinatesByKeywordOnly(@Param("keyword") String keyword);
}
