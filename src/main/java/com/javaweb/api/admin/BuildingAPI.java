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
import java.util.Objects;
import java.util.stream.Collectors;
import javax.persistence.EntityNotFoundException;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController(value = "buildingAPIOfAdmin")
@RequestMapping("/api/building")
@Validated
public class BuildingAPI {

  @Autowired
  private IBuildingService buildingService;
  @Autowired
  private IUserService userService;


  @PostMapping
  public ResponseEntity<String> addOrUpdateBuilding(
      @Valid @RequestBody BuildingRequestDTO buildingRequestDTO) {
    if (buildingRequestDTO.getId() == null) {
      buildingService.create(buildingRequestDTO);
      return ResponseEntity.status(HttpStatus.CREATED).body("Building created successfully.");
    } else {
      buildingService.update(buildingRequestDTO);
      return ResponseEntity.ok("Building updated successfully.");
    }
  }


  @PostMapping(value = "/assignment")
  public ResponseEntity<String> assignmentBuildingForStaffs(
      @RequestBody AssignmentBuildingRequest assignmentBuildingRequest) {
    try {
      BuildingEntity building = buildingService.findBuildingById(
          assignmentBuildingRequest.getBuildingId());
      if (building == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Building not found.");
      }

      List<UserEntity> staffs = assignmentBuildingRequest.getStaffs().stream()
          .map(userService::findById)
          .filter(Objects::nonNull)
          .collect(Collectors.toList());

      building.setUserEntities(staffs);
      buildingService.save(building);

      return ResponseEntity.ok("Assignment completed successfully.");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("An error occurred during the assignment process: " + e.getMessage());
    }
  }


  @DeleteMapping("/{id}")
  public ResponseEntity<?> deleteBuilding(@PathVariable Long id) {
    try {
      buildingService.delete(id);
      return ResponseEntity.ok("Building deleted successfully.");
    } catch (EntityNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Building not found.");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("An error occurred while deleting the building: " + e.getMessage());
    }
  }

  @DeleteMapping("/delete-{ids}")
  public ResponseEntity<?> deleteBuildings(@PathVariable List<Long> ids) {
    try {
      buildingService.delete(ids);
      return ResponseEntity.ok("Buildings deleted successfully.");
    } catch (EntityNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body("One or more buildings were not found.");
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body("An error occurred while deleting buildings: " + e.getMessage());
    }
  }

  @GetMapping("/{id}/staffs")
  public ResponseEntity<?> loadStaffs(@PathVariable Long id) {
    try {
      ResponseDTO result = buildingService.listStaffs(id);
      if (result == null) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(null);
      }
      return ResponseEntity.ok(result);
    } catch (EntityNotFoundException e) {
      return ResponseEntity.status(HttpStatus.NOT_FOUND)
          .body(null);
    } catch (Exception e) {
      return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
          .body(null);
    }
  }


}
