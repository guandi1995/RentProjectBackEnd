package com.dguan.project_rent.controller.customer;

import com.dguan.project_rent.dto.FloorPlan;
import com.dguan.project_rent.service.FloorPlanListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * customer controller for the webpage of locations/xxx/xxx.vue
 * goals:
 * - query floorplan list based on community id
 * - check availability based on community id and floorplan id
 * @author dguan
 * @date 12/30/2020 12:10 PM
 */
@RestController
@RequestMapping("/api/customer")
public class FloorPlanListController {

    @Autowired
    private FloorPlanListService floorPlanListService;

    /**
     * query the floorplan list based on community_id
     * @param community_id
     * @return
     */
    @GetMapping("/floorplanList/{community_id}")
    public List<FloorPlan> findFloorplanList(@PathVariable("community_id") String community_id){
        System.out.println("id="+community_id);
        return floorPlanListService.findFloorPlanList(community_id);
    }

    /**
     * query the available apartment based on community_id and apt_isavailable
     * @param community_id
     * @param apt_isavailable
     * @return
     */
    @GetMapping("/checkAvailability/{community_id}/{apt_isavailable}")
    public List<Map> checkAvailability(@PathVariable("community_id") String community_id,
                                       @PathVariable("apt_isavailable") String apt_isavailable){
        System.out.println("community_id:"+community_id);
        System.out.println("apt_isavailable:"+apt_isavailable);
        return floorPlanListService.checkAvailability(community_id, apt_isavailable);
    }
}
