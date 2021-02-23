package com.dguan.project_rent.service.implementation;

import com.dguan.project_rent.dto.FloorPlan;
import com.dguan.project_rent.mapper.FloorPlanListMapper;
import com.dguan.project_rent.service.FloorPlanListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * @author dguan
 * @date 12/30/2020 1:26 PM
 */
@Service
public class FloorPlanListServiceImpl implements FloorPlanListService {

    @Autowired
    private FloorPlanListMapper floorPlanListMapper;

    @Override
    public List<FloorPlan> findFloorPlanList(String community_id) {
        return floorPlanListMapper.findFloorPlanList(community_id);
    }

    @Override
    public List<Map> checkAvailability(String community_id, String apt_isavailable) {
        return floorPlanListMapper.checkAvailability(community_id, apt_isavailable);
    }
}
