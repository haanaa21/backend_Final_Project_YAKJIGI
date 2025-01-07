package com.ict.edu.yakjigi.domain.Mybasicboardlog.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ict.edu.yakjigi.domain.Mybasicboardlog.mapper.MybasicboardlogMapper;
import com.ict.edu.yakjigi.domain.Mybasicboardlog.vo.MybasicboardlogVO;

@Service
public class MybasicboardlogServiceImpl implements MybasicboardlogService {

    @Autowired
    private MybasicboardlogMapper mybasicboardlogMapper;

    @Override
    public List<MybasicboardlogVO> getUserDoses(String userId) {
        return mybasicboardlogMapper.getUserDoses(userId);
    }

    @Override
    public List<MybasicboardlogVO> getDetailsByDateAndUser(String date, String userId) {
        return mybasicboardlogMapper.getDetailsByDateAndUser(date, userId);
    }

    @Override
    public void deleteDose(String userId, String date) {
        mybasicboardlogMapper.deleteDose(userId, date);
    }

}
