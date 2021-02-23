package com.dguan.project_rent.service;

import com.dguan.project_rent.dto.CustomerInfo;
import com.dguan.project_rent.dto.Message;

/**
 * @author dguan
 * @date 1/3/2021 12:29 PM
 */
public interface CustomerSignupService {
    Message insertCustomerInfo(CustomerInfo customerInfo);
    Message checkUser(String username);
}
