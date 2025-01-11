package com.ict.edu.yakjigi.domain.userdose.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ict.edu.yakjigi.domain.userdose.mapper.UserdoseMapper;
import com.ict.edu.yakjigi.domain.userdose.vo.PayloadVO;
import com.ict.edu.yakjigi.domain.userdose.vo.UserdoseVO;

@Service
@Transactional
public class UserdoseServiceImpl implements UserdoseService {

    @Autowired
    private UserdoseMapper userdoseMapper;

    @Override
    public List<UserdoseVO> getUserDoses(String userId) {
        return userdoseMapper.getUserDoses(userId);
    }

    @Override
    public List<UserdoseVO> getDetailsByDateAndUser(String date, String userId) {
        return userdoseMapper.getDetailsByDateAndUser(date, userId);
    }

    @Override
    public void deleteDose(String userId, String date) {
        userdoseMapper.deleteDose(Integer.parseInt(userId), date);
    }

    @Override
    public void saveMyBasicBoardLog(PayloadVO payloadVO) {
        payloadVO.getMedications().forEach(medication -> {
            UserdoseVO vo = new UserdoseVO();
            vo.setUser_idx(payloadVO.getUser_idx());
            vo.setDose_date(payloadVO.getDose_date());

            String cleanedDoseOther = payloadVO.getDose_other().replaceAll("(?i)<p>|</p>", "");
            vo.setDose_other(cleanedDoseOther);

            vo.setMedi_name(medication.getMedi_name());
            vo.setDose_way(medication.getDose_way());
            vo.setDose_purpose(medication.getDose_purpose());

            userdoseMapper.insertMyBasicBoardLog(vo);
        });
    }

    @Override
    public void updateDose(PayloadVO payloadVO) {
        if (payloadVO.getDose_date() == null) {
            throw new IllegalArgumentException("dose_date is required and cannot be null.");
        }
    
        String doseDate = payloadVO.getDose_date().toString();
        // 기존 데이터 삭제
        userdoseMapper.deleteDose(payloadVO.getUser_idx(), payloadVO.getDose_date().toString());

        // 새로운 데이터 삽입
        saveMyBasicBoardLog(payloadVO);
    }
}
