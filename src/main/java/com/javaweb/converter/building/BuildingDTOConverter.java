package com.javaweb.converter.building;

import com.javaweb.enums.DistrictCode;
import com.javaweb.model.dto.BuildingDTO;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.javaweb.entity.BuildingEntity;

@Component
public class BuildingDTOConverter {

  @Autowired
  private ModelMapper modelMapper;

  public BuildingDTO toBuildingDTO(BuildingEntity item) {
    BuildingDTO buildingDTO = modelMapper.map(item, BuildingDTO.class);

    buildingDTO.setAddress(
        item.getStreet() + ", " + item.getWard() + ", " + DistrictCode.valueOf(item.getDistrict())
            .getDistrictName());
    String rentAreaValue = item.getAreas().stream().map(it -> it.getValue().toString())
        .collect(Collectors.joining(","));

    buildingDTO.setRentArea(rentAreaValue);

    return buildingDTO;
  }
}
