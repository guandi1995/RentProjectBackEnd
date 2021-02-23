package com.dguan.project_rent.controller.pagejump;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * page jumper index page
 * @author dguan
 * @date 12/23/2020 8:42 PM
 */

@Controller
public class CustomerMainPageJump {
    @RequestMapping("")
    public String toCustomerIndex(){ return "/customer/index"; }
    @RequestMapping("/aboutus")
    public String toAboutus(){
        return "/customer/aboutus/aboutus";
    }
    @RequestMapping("/locations")
    public String toLocations(){
        return "/customer/locations/locations";
    }

}
