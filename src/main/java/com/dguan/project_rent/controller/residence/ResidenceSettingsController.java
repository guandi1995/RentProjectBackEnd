package com.dguan.project_rent.controller.residence;

import com.dguan.project_rent.config.EmailConfig;
import com.dguan.project_rent.dto.EmailContent;
import com.dguan.project_rent.dto.Message;
import com.dguan.project_rent.service.ResidenceSettingsService;
import com.dguan.project_rent.utils.GenerateVerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author dguan
 * @date 1/11/2021 10:23 PM
 */
@RestController
@RequestMapping("/api/residence")
public class ResidenceSettingsController {

    @Autowired
    private ResidenceSettingsService residenceSettingsService;

    @PostMapping( "/sendEmail")
    public Message sendEmail(@RequestBody Map map){
        String email = (String) map.get("email");
        Message message = new Message();

        /**
         * check whether the email address is correct
         * if correct, send mail with verification code
         * otherwise
         */
        Boolean correct = residenceSettingsService.checkEmail(email);
        //send email if email is correct
        if(correct){
            //generate verification code
            GenerateVerificationCode generateVerificationCode = new GenerateVerificationCode();
            StringBuffer code = generateVerificationCode.generateCode();
            //create EmailContent instance and set the properties
            EmailContent emailContent = new EmailContent();
            emailContent.setTitle("DO-NOT-REPLY");
            emailContent.setEmailFrom("RentService@email.com");
            emailContent.setEmailTo(email);
            emailContent.setEmailBody("Your verification code is: "+code.toString());
            Boolean sent = residenceSettingsService.sendEmail(emailContent);
            if (sent){
                message.setStatus(true);
                message.setMessage("Email has been sent");
            }else {
                message.setStatus(false);
                message.setMessage("Server is unable to send email, please try again later");
            }
        }
        //otherwise return the message of email is incorrect
        else {
            message.setMessage("Email is incorrect, please enter the correct email");
            message.setStatus(false);
        }
        return message;
    }

    @PostMapping(value = "/changePassword")
    public Message changePassword(@RequestBody Map map){
        System.out.println(map);
        Message message = residenceSettingsService.changePassword(map);
        return message;
    }
}
