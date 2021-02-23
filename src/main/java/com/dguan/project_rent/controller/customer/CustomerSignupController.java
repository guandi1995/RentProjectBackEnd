package com.dguan.project_rent.controller.customer;

import com.dguan.project_rent.dto.CustomerInfo;
import com.dguan.project_rent.dto.Message;
import com.dguan.project_rent.service.CustomerSignupService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

/**
 * @author dguan
 * @date 1/1/2021 10:45 PM
 */
@Controller
@RequestMapping("/signup")
public class CustomerSignupController {
    @Autowired
    private CustomerSignupService customerSignupService;

    @RequestMapping(value = "/submitForm", method = RequestMethod.POST)
    @ResponseBody
    public Message submitForm(@RequestBody CustomerInfo customerInfo){
        System.out.println(customerInfo);
        Message message = customerSignupService.insertCustomerInfo(customerInfo);
        System.out.println(message);
        return message;
    }

    @RequestMapping(value = "/checkUser", method = RequestMethod.POST)
    @ResponseBody
    public Message checkUser(@RequestBody String username){
        customerSignupService.checkUser(username);
        Message message = customerSignupService.checkUser(username);
        System.out.println(message);
        return message;
    }
}
