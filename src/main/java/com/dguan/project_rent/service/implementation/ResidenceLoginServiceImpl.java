package com.dguan.project_rent.service.implementation;

import com.dguan.project_rent.dto.*;
import com.dguan.project_rent.mapper.ResidenceLoginMapper;
import com.dguan.project_rent.service.ResidenceLoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author dguan
 * @date 1/4/2021 7:19 PM
 */
@Service
public class ResidenceLoginServiceImpl implements ResidenceLoginService {
    @Autowired
    private ResidenceLoginMapper residenceLoginMapper;

    @Override
    public Message findUsernamePassword(Map map, HttpServletRequest request) {
        Message message = new Message();
        return message;
    }

    @Override
    public List<ApartmentInfo> findAptInfoById(String residence_id) {
        return residenceLoginMapper.findAptInfoById(residence_id);
    }

    /**
     * query the ResidenceLogin by residence_username in shiro
     * @param username
     * @return
     */
    @Override
    public List<ResidenceLogin> queryByUsername(String username) {
        List<ResidenceLogin> list = residenceLoginMapper.queryByUsername(username);
        return list;
    }

    /**
     * query the ResidenceInfo by residence_id and put the residence info into the session
     * @param residence_id
     * @return
     */
    @Override
    public List<ResidenceInfo> queryResidenceInfoById(String residence_id) {
        return residenceLoginMapper.queryResidenceInfoById(residence_id);
    }

}
