package com.ict.edu.yakjigi.domain.userdose.service;

import java.util.List;

import com.ict.edu.yakjigi.domain.userdose.vo.PayloadVO;
import com.ict.edu.yakjigi.domain.userdose.vo.UserdoseVO;

public interface UserdoseService {
    List<UserdoseVO> getUserDoses(String userId);
    List<UserdoseVO> getDetailsByDateAndUser(String date, String userId);
    void deleteDose(String userId, String date);
    void saveMyBasicBoardLog(PayloadVO payloadVO);
    void updateDose(PayloadVO payloadVO); // 수정 기능 메서드
}

