package com.dguan.project_rent.dto;

import lombok.Data;

/**
 * @author dguan
 * @date 2/20/2021 11:25 AM
 */
@Data
public class EmailContent {
    private String title;
    private String emailFrom;
    private String emailTo;
    private String emailBody;
}
