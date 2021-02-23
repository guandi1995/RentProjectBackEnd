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

        //check the email
        Boolean correct = residenceSettingsService.checkEmail(email);
        if(correct){
            GenerateVerificationCode generateVerificationCode = new GenerateVerificationCode();
            StringBuffer code = generateVerificationCode.generateCode();
            EmailContent emailContent = new EmailContent();
            emailContent.setName("DO-NOT-REPLY");
            emailContent.setEmailTo(email);
            emailContent.setEmailFrom("RentService@email.com");
            emailContent.setEmailBody(code.toString());
            Boolean aBoolean = residenceSettingsService.sendEmail(emailContent);
            message.setStatus(true);
            message.setMessage("email has been sent");
        }else {
            message.setMessage("email is incorrect");
            message.setStatus(false);
        }
        return message;
    }

    @PostMapping(value = "/changePassword/{id}")
    public Message changePassword(@PathVariable String id, @RequestBody Map map){
        map.put("id", id);
        System.out.println(map);
        Message message = residenceSettingsService.changePassword(map);
        return message;
    }
}
