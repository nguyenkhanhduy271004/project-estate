package com.javaweb.service.impl;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.converter.building.BuildingDTOConverter;
import com.javaweb.converter.building.BuildingEntityConverter;
import com.javaweb.converter.building.BuildingSearchBuilderConverter;
import com.javaweb.entity.UserEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingRequestDTO;
import com.javaweb.model.response.ResponseDTO;
import com.javaweb.model.response.StaffResponseDTO;
import com.javaweb.repository.BuildingRepository;
import com.javaweb.entity.BuildingEntity;
import com.javaweb.repository.RentAreaRepository;
import com.javaweb.repository.UserRepository;
import com.javaweb.service.IBuildingService;
import com.javaweb.utils.UploadFileUtils;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BuildingServiceImpl implements IBuildingService {

  @Autowired
  private BuildingRepository buildingRepository;
  @Autowired
  private RentAreaRepository rentAreaRepository;
  @Autowired
  private BuildingDTOConverter buildingDTOConverter;
  @Autowired
  private BuildingEntityConverter buildingEntityConverter;
  @Autowired
  private BuildingSearchBuilderConverter buildingSearchBuilderConverter;
  @Autowired
  private UserRepository userRepository;
  @Autowired
  private UploadFileUtils uploadFileUtils;

  @Override
  public List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode, int page,
      int size) {
    BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(
        params,
        typeCode);
    List<BuildingEntity> buildingEntities = buildingRepository.findAll(buildingSearchBuilder, page,
        size);
    List<BuildingDTO> result = new ArrayList<>();
    for (BuildingEntity item : buildingEntities) {
      BuildingDTO buildingDTO = buildingDTOConverter.toBuildingDTO(item);
      result.add(buildingDTO);
    }
    return result;
  }

  @Override
  public Long countBuildings(Map<String, Object> params, List<String> typeCode) {
    BuildingSearchBuilder buildingSearchBuilder = buildingSearchBuilderConverter.toBuildingSearchBuilder(
        params,
        typeCode
    );
    return buildingRepository.count(buildingSearchBuilder);
  }


  @Override
  public void create(BuildingRequestDTO buildingRequestDTO) {
    BuildingEntity buildingEntity = buildingEntityConverter.toBuildingEntity(buildingRequestDTO);
    buildingRepository.save(buildingEntity);
  }

  @Override
  public void update(BuildingRequestDTO buildingRequestDTO) {
    BuildingEntity existBuilding = buildingRepository.findById(buildingRequestDTO.getId()).get();
    rentAreaRepository.deleteRentAreaWithBuildingId(existBuilding.getId());
    existBuilding = buildingEntityConverter.updateBuildingEntity(existBuilding, buildingRequestDTO);
    buildingRepository.save(existBuilding);
  }


  @Override
  public void delete(Long id) {
    buildingRepository.deleteById(id);
  }

  @Override
  public void delete(List<Long> ids) {
    buildingRepository.deleteByIdIn(ids);
  }

  @Override
  public ResponseDTO listStaffs(Long buildingId) {
    BuildingEntity building = buildingRepository.findById(buildingId).get();
    List<UserEntity> staffs = userRepository.findByStatusAndRoles_Code(1, "STAFF");
    List<UserEntity> staffAsignment = building.getUserEntities();
    List<StaffResponseDTO> staffResponseDTOS = new ArrayList<>();
    for (UserEntity staff : staffs) {
      StaffResponseDTO staffResponseDTO = new StaffResponseDTO();
      staffResponseDTO.setStaffId(staff.getId());
      staffResponseDTO.setFullName(staff.getFullName());
      if (staffAsignment.contains(staff)) {
        staffResponseDTO.setChecked("checked");
      } else {
        staffResponseDTO.setChecked("");
      }
      staffResponseDTOS.add(staffResponseDTO);
    }
    ResponseDTO responseDTO = new ResponseDTO();
    responseDTO.setData(staffResponseDTOS);
    responseDTO.setMessage("Success");
    return responseDTO;
  }

  @Override
  public BuildingRequestDTO find(Long id) {
    BuildingEntity buildingEntity = buildingRepository.findById(id).get();
    BuildingRequestDTO buildingRequestDTO = buildingEntityConverter.toBuildingRequestDTO(
        buildingEntity);
    return buildingRequestDTO;
  }

  @Override
  public BuildingEntity findBuildingById(Long id) {
    return buildingRepository.findById(id).get();
  }

  @Override
  public void save(BuildingEntity buildingEntity) {
    buildingRepository.save(buildingEntity);
  }

}
