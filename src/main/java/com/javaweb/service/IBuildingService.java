package com.javaweb.service;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.model.dto.BuildingDTO;
import com.javaweb.model.request.BuildingRequestDTO;
import com.javaweb.model.response.ResponseDTO;
import java.util.List;
import java.util.Map;

public interface IBuildingService {

  List<BuildingDTO> findAll(Map<String, Object> params, List<String> typeCode, int page, int size);

  Long countBuildings(Map<String, Object> params, List<String> typeCode);

  BuildingRequestDTO find(Long id);

  BuildingEntity findBuildingById(Long id);

  void save(BuildingEntity buildingEntity);

  void create(BuildingRequestDTO buildingRequestDTO);

  void update(BuildingRequestDTO buildingRequestDTO);

  void delete(Long id);

  void delete(List<Long> ids);

  ResponseDTO listStaffs(Long buildingId);
}
