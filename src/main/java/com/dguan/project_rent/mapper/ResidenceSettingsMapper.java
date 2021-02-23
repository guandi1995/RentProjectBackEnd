package com.dguan.project_rent.mapper;

import com.dguan.project_rent.dto.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dguan
 * @date 1/11/2021 5:35 PM
 */
@Repository
@Mapper
public interface ResidenceSettingsMapper {
    List<CustomerInfo> findResidenceById(String id);
    void changePassword(Map map);
}
