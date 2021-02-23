package com.dguan.project_rent.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dguan
 * @date 1/19/2021 11:08 PM
 */
@Data
public class ResidenceInfo implements Serializable {
    private String residence_id;
    private String residence_username;
    private String residence_password;
    private String residence_firstname;
    private String residence_lastname;
    private String residence_address;
    private String residence_email;
    private String residence_phone;
    private String residence_gender;
    private Date residence_birth;
    private String residence_marital;
    private Integer residence_income;
    private String residence_security1;
    private String residence_security1_ans;
    private String residence_security2;
    private String residence_security2_ans;
}
