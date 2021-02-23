package com.dguan.project_rent.service;

import com.dguan.project_rent.dto.FloorPlan;

import java.util.List;
import java.util.Map;

/**
 * @author dguan
 * @date 12/30/2020 1:19 PM
 */
public interface FloorPlanListService {
    List<FloorPlan> findFloorPlanList(String community_id);
    List<Map> checkAvailability(String community_id, String apt_isavailable);
}
