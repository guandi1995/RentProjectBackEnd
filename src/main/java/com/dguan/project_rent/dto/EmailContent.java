package com.dguan.project_rent.dto;

import com.sun.istack.internal.NotNull;
import lombok.Data;

/**
 * @author dguan
 * @date 2/20/2021 11:25 AM
 */
@Data
public class EmailContent {
    private String name;
    private String emailFrom;
    private String emailTo;
    private String emailBody;
}
