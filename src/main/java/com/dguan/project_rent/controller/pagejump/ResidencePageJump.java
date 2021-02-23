package com.dguan.project_rent.controller.pagejump;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author dguan
 * @date 1/4/2021 1:35 AM
 */
@Controller
@RequestMapping("/residence")

public class ResidencePageJump {
    @RequestMapping("/toLogin")
    public String toResidenceLogin(){
        return "/residence/login";
    }

    @RequestMapping("/toSignup")
    public String toSignup(){
        return "/residence/signup";
    }

    @RequestMapping("/index")
    public String toIndex(){
        return "/residence/index";
    }

    @RequestMapping("/toProfile")
    public String toResidenceProfile(){
        return "/residence/profile";
    }

    @RequestMapping("/toPayRent")
    public String toPayRent(){ return "/residence/rent"; }

    @RequestMapping("/toAccountHistory")
    public String toAccountHistory(){
        return "/residence/history";
    }

    @RequestMapping("/toSavedPaymentAccount")
    public String toSavedPaymentAccount(){return "/residence/saved";}

    @RequestMapping("/toChangePassword")
    public String toChangePassword(){return"/residence/password";}

    @RequestMapping("/toGeneralSettings")
    public String toGeneralSettings(){return"/residence/settings";}

}
