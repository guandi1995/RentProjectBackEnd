package com.dguan.project_rent.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author dguan
 * @date 1/9/2021 6:18 PM
 */
@Data
public class Module implements Serializable {
    private Integer module_id;
    private String module_name;
    private String module_url;
    private Module parent;
    private List<Module> children;
}
