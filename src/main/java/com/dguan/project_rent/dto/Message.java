package com.dguan.project_rent.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dguan
 * @date 1/3/2021 12:29 PM
 */
@Data
public class Message implements Serializable {
    private Boolean status;
    private String message;

}
