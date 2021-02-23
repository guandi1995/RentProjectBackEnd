package com.dguan.project_rent.mapper;

import com.dguan.project_rent.dto.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dguan
 * @date 1/4/2021 7:14 PM
 */
@Repository
@Mapper
public interface ResidenceLoginMapper {
    List<CustomerInfo> findUsernamePassword(Map map);

    List<ApartmentInfo> findAptInfoById(String id);
    List<ResidenceLogin> queryByUsername(String username);
    List<ResidenceInfo> queryResidenceInfoById(String residence_id);
}
