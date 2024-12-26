package com.javaweb.api.admin;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.request.AssignmentBuildingRequest;
import com.javaweb.model.request.BuildingRequestDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.service.IBuildingService;
import com.javaweb.service.IUserService;
import com.javaweb.service.impl.UserService;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "buildingAPIOfAdmin")
@RequestMapping("/api/building")
public class BuildingAPI {

  @Autowired
  private IBuildingService buildingService;
  @Autowired
  private IUserService userService;


  @PostMapping
  public void addOrUpdateBuilding(@RequestBody BuildingRequestDTO buildingRequestDTO) {
    if (buildingRequestDTO.getId() == null) {
      buildingService.create(buildingRequestDTO);
    } else {
      buildingService.update(buildingRequestDTO);
    }
  }

  @PostMapping(value = "/assignment")
  public void assignmentBuildingForStaffs(
      @RequestBody AssignmentBuildingRequest assignmentBuildingRequest) {
    BuildingEntity building = buildingService.findBuildingById(
        assignmentBuildingRequest.getBuildingId());
    List<UserEntity> staffs = new ArrayList<>();
    for (Long staffId : assignmentBuildingRequest.getStaffs()) {
      UserEntity userEntity = userService.findById(staffId);
      staffs.add(userEntity);
    }

    building.setUserEntities(staffs);
    buildingService.save(building);
  }

  @DeleteMapping("/{id}")
  public void deleteBuilding(@PathVariable Long id) {
    buildingService.delete(id);
  }

  @DeleteMapping("/delete-{ids}")
  public void deleteBuildings(@PathVariable List<Long> ids) {
    buildingService.delete(ids);
  }

  @GetMapping("/{id}/staffs")
  public ResponseDTO loadStaffs(@PathVariable Long id) {
    ResponseDTO result = buildingService.listStaffs(id);
    return result;
  }


}
