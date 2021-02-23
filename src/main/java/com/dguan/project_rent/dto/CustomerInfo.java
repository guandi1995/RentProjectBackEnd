package com.dguan.project_rent.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dguan
 * @date 12/27/2020 9:05 PM
 */
@Data
public class CustomerInfo implements Serializable {
    private String customer_id;
    private String customer_username;
    private String customer_password;
    private String customer_firstname;
    private String customer_lastname;
    private String customer_address;
    private String customer_email;
    private String customer_phone;
    private String customer_gender;
    private Date customer_birth;
    private String customer_marital;
    private Integer customer_income;
    private String customer_security1;
    private String customer_security1_ans;
    private String customer_security2;
    private String customer_security2_ans;
}
