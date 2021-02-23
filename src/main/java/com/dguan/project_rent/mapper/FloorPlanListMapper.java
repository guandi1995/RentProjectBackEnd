package com.dguan.project_rent.mapper;

import com.dguan.project_rent.dto.FloorPlan;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

/**
 * @author dguan
 * @date 12/30/2020 1:27 PM
 */
@Repository
@Mapper
public interface FloorPlanListMapper {
    List<FloorPlan> findFloorPlanList(String community_id);
    List<Map> checkAvailability(@Param("community_id") String community_id, @Param("apt_isavailable") String apt_isavailable);
}
