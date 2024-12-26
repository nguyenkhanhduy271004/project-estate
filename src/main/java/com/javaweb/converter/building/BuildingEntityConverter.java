package com.javaweb.converter.building;

import com.javaweb.entity.BuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.request.BuildingRequestDTO;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BuildingEntityConverter {

  @Autowired
  private ModelMapper modelMapper;

  public BuildingEntity toBuildingEntity(BuildingRequestDTO buildingRequestDTO) {
    BuildingEntity buildingEntity = new BuildingEntity();
    buildingEntity.setName(buildingRequestDTO.getName());
    buildingEntity.setWard(buildingRequestDTO.getWard());
    buildingEntity.setStreet(buildingRequestDTO.getStreet());
    buildingEntity.setDistrict(buildingRequestDTO.getDistrict());
    buildingEntity.setRentPrice(buildingRequestDTO.getRentPrice());
    buildingEntity.setStructure(buildingRequestDTO.getStructure());
    buildingEntity.setNumberOfBasement(buildingRequestDTO.getNumberOfBasement());
    buildingEntity.setFloorArea(buildingRequestDTO.getFloorArea());
    buildingEntity.setDirection(buildingRequestDTO.getDirection());
    buildingEntity.setLevel(buildingRequestDTO.getLevel());
    List<RentAreaEntity> areas = Arrays.stream(buildingRequestDTO.getRentArea().split(","))
        .map(String::trim)
        .filter(area -> !area.isEmpty())
        .map(area -> {
          RentAreaEntity rentAreaEntity = new RentAreaEntity();
          rentAreaEntity.setValue(Long.parseLong(area));
          rentAreaEntity.setBuilding(buildingEntity);
          return rentAreaEntity;
        })
        .collect(Collectors.toList());
    buildingEntity.setAreas(areas);
    buildingEntity.setRentDescription(buildingRequestDTO.getRentPriceDescription());
    buildingEntity.setServiceFee(buildingRequestDTO.getServiceFee());
    buildingEntity.setCarFee(buildingRequestDTO.getCarFee());
    buildingEntity.setMotoFee(buildingRequestDTO.getMotoFee());
    buildingEntity.setOvertimeFee(buildingRequestDTO.getOvertimeFee());
    buildingEntity.setElectricityFee(buildingRequestDTO.getElectricityFee());
    buildingEntity.setDeposit(buildingRequestDTO.getDeposit());
    buildingEntity.setPayment(buildingRequestDTO.getPayment());
    buildingEntity.setRentTime(buildingRequestDTO.getRentTime());
    buildingEntity.setDecorationTime(buildingRequestDTO.getDecorationTime());
    buildingEntity.setManagerName(buildingRequestDTO.getManagerName());
    buildingEntity.setManagerPhone(buildingRequestDTO.getManagerPhone());
    buildingEntity.setBrokerageFee(buildingRequestDTO.getBrokerageFee());
    String typeCode = buildingRequestDTO.getTypeCode().stream()
        .collect(Collectors.joining(","));
    buildingEntity.setType(typeCode);
    return buildingEntity;
  }

  public BuildingRequestDTO toBuildingRequestDTO(BuildingEntity buildingEntity) {
    BuildingRequestDTO buildingRequestDTO = new BuildingRequestDTO();
    buildingRequestDTO.setId(buildingEntity.getId());
    buildingRequestDTO.setName(buildingEntity.getName());
    buildingRequestDTO.setWard(buildingEntity.getWard());
    buildingRequestDTO.setStreet(buildingEntity.getStreet());
    buildingRequestDTO.setDistrict(buildingEntity.getDistrict());
    buildingRequestDTO.setRentPrice(buildingEntity.getRentPrice());
    buildingRequestDTO.setStructure(buildingEntity.getStructure());
    buildingRequestDTO.setNumberOfBasement(buildingEntity.getNumberOfBasement());
    buildingRequestDTO.setFloorArea(buildingEntity.getFloorArea());
    buildingRequestDTO.setDirection(buildingEntity.getDirection());
    buildingRequestDTO.setLevel(buildingEntity.getLevel());

    String rentArea = buildingEntity.getAreas().stream()
        .map(area -> String.valueOf(area.getValue()))
        .collect(Collectors.joining(","));
    buildingRequestDTO.setRentArea(rentArea);

    buildingRequestDTO.setRentPriceDescription(buildingEntity.getRentDescription());
    buildingRequestDTO.setServiceFee(buildingEntity.getServiceFee());
    buildingRequestDTO.setCarFee(buildingEntity.getCarFee());
    buildingRequestDTO.setMotoFee(buildingEntity.getMotoFee());
    buildingRequestDTO.setOvertimeFee(buildingEntity.getOvertimeFee());
    buildingRequestDTO.setElectricityFee(buildingEntity.getElectricityFee());
    buildingRequestDTO.setDeposit(buildingEntity.getDeposit());
    buildingRequestDTO.setPayment(buildingEntity.getPayment());
    buildingRequestDTO.setRentTime(buildingEntity.getRentTime());
    buildingRequestDTO.setDecorationTime(buildingEntity.getDecorationTime());
    buildingRequestDTO.setManagerName(buildingEntity.getManagerName());
    buildingRequestDTO.setManagerPhone(buildingEntity.getManagerPhone());
    buildingRequestDTO.setBrokerageFee(buildingEntity.getBrokerageFee());

    List<String> typeCodeList = Arrays.asList(buildingEntity.getType().split(","));
    buildingRequestDTO.setTypeCode(typeCodeList);

    return buildingRequestDTO;
  }

  public BuildingEntity updateBuildingEntity(BuildingEntity buildingEntity,
      BuildingRequestDTO buildingRequestDTO) {
    buildingEntity.setName(buildingRequestDTO.getName());
    buildingEntity.setWard(buildingRequestDTO.getWard());
    buildingEntity.setStreet(buildingRequestDTO.getStreet());
    buildingEntity.setDistrict(buildingRequestDTO.getDistrict());
    buildingEntity.setRentPrice(buildingRequestDTO.getRentPrice());
    buildingEntity.setStructure(buildingRequestDTO.getStructure());
    buildingEntity.setNumberOfBasement(buildingRequestDTO.getNumberOfBasement());
    buildingEntity.setFloorArea(buildingRequestDTO.getFloorArea());
    buildingEntity.setDirection(buildingRequestDTO.getDirection());
    buildingEntity.setLevel(buildingRequestDTO.getLevel());

    List<RentAreaEntity> areas = Arrays.stream(buildingRequestDTO.getRentArea().split(","))
        .map(String::trim)
        .filter(area -> !area.isEmpty())
        .map(area -> {
          RentAreaEntity rentAreaEntity = new RentAreaEntity();
          rentAreaEntity.setValue(Long.parseLong(area));
          rentAreaEntity.setBuilding(buildingEntity);
          return rentAreaEntity;
        })
        .collect(Collectors.toList());

    buildingEntity.setAreas(areas);

    buildingEntity.setRentDescription(buildingRequestDTO.getRentPriceDescription());
    buildingEntity.setServiceFee(buildingRequestDTO.getServiceFee());
    buildingEntity.setCarFee(buildingRequestDTO.getCarFee());
    buildingEntity.setMotoFee(buildingRequestDTO.getMotoFee());
    buildingEntity.setOvertimeFee(buildingRequestDTO.getOvertimeFee());
    buildingEntity.setElectricityFee(buildingRequestDTO.getElectricityFee());
    buildingEntity.setDeposit(buildingRequestDTO.getDeposit());
    buildingEntity.setPayment(buildingRequestDTO.getPayment());
    buildingEntity.setRentTime(buildingRequestDTO.getRentTime());
    buildingEntity.setDecorationTime(buildingRequestDTO.getDecorationTime());
    buildingEntity.setManagerName(buildingRequestDTO.getManagerName());
    buildingEntity.setManagerPhone(buildingRequestDTO.getManagerPhone());
    buildingEntity.setBrokerageFee(buildingRequestDTO.getBrokerageFee());

    if (buildingRequestDTO.getTypeCode() != null) {
      String type = String.join(",", buildingRequestDTO.getTypeCode());
      buildingEntity.setType(type);
    }

    return buildingEntity;
  }

}
