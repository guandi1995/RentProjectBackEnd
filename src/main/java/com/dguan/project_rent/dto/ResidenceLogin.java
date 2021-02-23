package com.dguan.project_rent.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dguan
 * @date 1/19/2021 11:08 PM
 */
@Data
public class ResidenceLogin implements Serializable {
    private String residence_id;
    private String residence_username;
    private String residence_password;
    private String residence_salt;
    private String residence_state;
}
