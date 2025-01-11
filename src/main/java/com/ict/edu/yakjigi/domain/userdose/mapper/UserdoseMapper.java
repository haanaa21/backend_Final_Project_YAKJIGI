package com.ict.edu.yakjigi.domain.userdose.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.ict.edu.yakjigi.domain.userdose.vo.UserdoseVO;

@Mapper
public interface UserdoseMapper {
    List<UserdoseVO> getUserDoses(@Param("userId") String userId);

    List<UserdoseVO> getDetailsByDateAndUser(@Param("date") String date, @Param("userId") String userId);

    void deleteDose(@Param("userId") int userId, @Param("date") String date);

    void insertMyBasicBoardLog(UserdoseVO requestData);
}
