package com.ict.edu.yakjigi.domain.Mybasicboardlog.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ict.edu.yakjigi.domain.Mybasicboardlog.vo.MybasicboardlogVO;

@Mapper
public interface MybasicboardlogMapper {
    List<MybasicboardlogVO> getUserDoses(@Param("userId") String userId);

    List<MybasicboardlogVO> getDetailsByDateAndUser(@Param("date") String date, @Param("userId") String userId);

    @Delete("DELETE FROM user_dose WHERE user_idx = #{userId} AND dose_date = #{date}")
    void deleteDose(@Param("userId") String userId, @Param("date") String date);

    void insertMyBasicBoardLog(MybasicboardlogVO requestData);
}
