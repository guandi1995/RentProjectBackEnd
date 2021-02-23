package com.dguan.project_rent.service.implementation;

import com.dguan.project_rent.config.EmailConfig;
import com.dguan.project_rent.dto.CustomerInfo;
import com.dguan.project_rent.dto.EmailContent;
import com.dguan.project_rent.dto.Message;
import com.dguan.project_rent.mapper.ResidenceSettingsMapper;
import com.dguan.project_rent.service.ResidenceSettingsService;
import com.dguan.project_rent.utils.GenerateVerificationCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author dguan
 * @date 1/11/2021 10:22 PM
 */
@Service
public class ResidenceSettingsServiceImpl implements ResidenceSettingsService {

    @Autowired
    private ResidenceSettingsMapper residenceSettingsMapper;
    @Autowired
    private EmailConfig emailConfig;

    @Override
    public Boolean checkEmail(String email) {
        return true;
    }

    @Override
    public Boolean sendEmail(EmailContent emailContent) {
        SimpleMailMessage simpleMailMessage = new SimpleMailMessage();
        simpleMailMessage.setFrom(emailContent.getEmailFrom());
        simpleMailMessage.setTo(emailContent.getEmailTo());
        simpleMailMessage.setSubject(emailContent.getName());
        simpleMailMessage.setText(emailContent.getEmailBody());
        emailConfig.MailSender().send(simpleMailMessage);
        return true;
    }

    @Override
    public Message changePassword(Map map) {

        String id = (String) map.get("id");
        List<CustomerInfo> residenceById = residenceSettingsMapper.findResidenceById(id);

        String old_pass_sql = residenceById.get(0).getCustomer_password();
        String old_pass_input = (String) map.get("old_password");
        String new_pass_input = (String) map.get("new_password");

        Message message = new Message();

        if (!old_pass_sql.equals(old_pass_input)){
            message.setStatus(false);
            message.setMessage("Old Password is not correct!");
        }else if (old_pass_sql.equals(new_pass_input)){
            message.setStatus(false);
            message.setMessage("New password is the same as old password!");
        }else{
            try{
                residenceSettingsMapper.changePassword(map);
                message.setStatus(true);
                message.setMessage("Update password successfully!");
            }catch (Exception e){
                System.out.println(e);
            }
        }
        return message;
    }
}
