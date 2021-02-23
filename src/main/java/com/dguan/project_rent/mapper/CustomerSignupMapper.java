package com.dguan.project_rent.mapper;

import com.dguan.project_rent.dto.CustomerInfo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author dguan
 * @date 1/3/2021 12:33 PM
 */
@Repository
@Mapper
public interface CustomerSignupMapper {
    Boolean insertCustomerInfo(CustomerInfo customerInfo);
    List<CustomerInfo> checkUser(String username);
}
