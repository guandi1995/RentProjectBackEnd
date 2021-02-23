package com.dguan.project_rent.service;

import com.dguan.project_rent.dto.ApartmentInfo;
import com.dguan.project_rent.dto.Message;
import com.dguan.project_rent.dto.ResidenceInfo;
import com.dguan.project_rent.dto.ResidenceLogin;

import javax.servlet.http.HttpServletRequest;
import java.util.List;
import java.util.Map;

/**
 * @author dguan
 * @date 1/4/2021 7:18 PM
 */
public interface ResidenceLoginService {
    Message findUsernamePassword(Map map, HttpServletRequest session);
    List<ApartmentInfo> findAptInfoById(String residence_id);
    List<ResidenceLogin> queryByUsername(String username);
    List<ResidenceInfo> queryResidenceInfoById(String residence_id);
}
