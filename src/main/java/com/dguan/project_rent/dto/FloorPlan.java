package com.dguan.project_rent.dto;

import lombok.Data;

import java.io.Serializable;

/**
 * @author dguan
 * @date 12/30/2020 1:22 PM
 */
@Data
public class FloorPlan  implements Serializable {
    private Integer floorplan_id;
    private Integer floorplan_num;
    private String floorplan_name;
    private Integer num_beds;
    private Integer num_baths;
    private Integer area;
    private Boolean is_loft;
    private Integer starting_price;
    private String img_url;
    private Integer community_id;
}
