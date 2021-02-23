package com.dguan.project_rent.service.implementation;

import com.dguan.project_rent.dto.CustomerInfo;
import com.dguan.project_rent.dto.Message;
import com.dguan.project_rent.mapper.CustomerSignupMapper;
import com.dguan.project_rent.service.CustomerSignupService;
import com.dguan.project_rent.utils.GenerateResidenceId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author dguan
 * @date 1/3/2021 12:32 PM
 */
@Service
public class CustomerSignupServiceImpl implements CustomerSignupService {

    @Autowired
    private CustomerSignupMapper customerSignupMapper;


    @Override
    public Message insertCustomerInfo(CustomerInfo customerInfo) {
        String customerId = GenerateResidenceId.getResidenceId();
        customerInfo.setCustomer_id(customerId);
        Message message = new Message();

        try {
            customerSignupMapper.insertCustomerInfo(customerInfo);
            message.setStatus(true);
            message.setMessage("sign up successfully");
        }catch (Exception e){
            System.out.println(e);
            message.setStatus(false);
            message.setMessage("sign up unsuccessfully");
        }
        return message;
    }

    @Override
    public Message checkUser(String username) {
        String sub_username = username.substring(0, username.length()-1);
        Message message = new Message();
        List<CustomerInfo> customerInfos = customerSignupMapper.checkUser(sub_username);
        if (customerInfos.isEmpty()){
            message.setStatus(true);
            message.setMessage("username is available");
        }else {
            message.setStatus(false);
            message.setMessage("username exists");
        }
        return message;
    }
}
