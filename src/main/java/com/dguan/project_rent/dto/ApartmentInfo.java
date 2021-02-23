package com.dguan.project_rent.dto;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author dguan
 * @date 12/30/2020 1:22 PM
 */
@Data
public class ApartmentInfo implements Serializable {
    private Integer apt_id;
    private Integer community_id;
    private Integer floorplan_id;
    private Integer apt_num;
    private Integer apt_floor;
    private Integer apt_lease_term;
    private Integer apt_min_term;
    private Integer apt_max_term;
    private Integer apt_price;
    private Date apt_start_date;
    private Date apt_end_date;
    private Boolean apt_isavailable;
    private Date apt_available_date;
    private Integer apt_deposit;
    private String residence_id;
}
