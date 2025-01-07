package com.ict.edu.yakjigi.domain.Mybasicboardlog.service;

import java.util.List;

import com.ict.edu.yakjigi.domain.Mybasicboardlog.vo.MybasicboardlogVO;

public interface MybasicboardlogService {
    List<MybasicboardlogVO> getUserDoses(String userId);
    List<MybasicboardlogVO> getDetailsByDateAndUser(String date, String userId);
    void deleteDose(String userId, String date);
}

