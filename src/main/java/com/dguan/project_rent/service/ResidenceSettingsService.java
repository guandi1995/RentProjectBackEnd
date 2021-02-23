package com.dguan.project_rent.service;

import com.dguan.project_rent.dto.EmailContent;
import com.dguan.project_rent.dto.Message;
import com.sun.org.apache.xpath.internal.operations.Bool;

import java.util.Map;

/**
 * @author dguan
 * @date 1/11/2021 10:21 PM
 */
public interface ResidenceSettingsService {
    Message changePassword(Map map);
    Boolean sendEmail(EmailContent emailContent);
    Boolean checkEmail(String email);
}
