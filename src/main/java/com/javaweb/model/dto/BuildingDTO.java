package com.javaweb.model.dto;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuildingDTO extends AbstractDTO {

  private String name;
  private String address;
  private String district;
  private Long numberOfBasement;
  private String managerName;
  private String managerPhone;
  private Long floorArea;
  private Long emptySpace;
  private String rentPrice;
  private String serviceFee;
  private String brokerageFee;
  private String rentArea;

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public Long getNumberOfBasement() {
    return numberOfBasement;
  }

  public void setNumberOfBasement(Long numberOfBasement) {
    this.numberOfBasement = numberOfBasement;
  }

  public String getManagerName() {
    return managerName;
  }

  public void setManagerName(String managerName) {
    this.managerName = managerName;
  }

  public String getManagerPhone() {
    return managerPhone;
  }

  public void setManagerPhone(String managerPhone) {
    this.managerPhone = managerPhone;
  }

  public Long getFloorArea() {
    return floorArea;
  }

  public void setFloorArea(Long floorArea) {
    this.floorArea = floorArea;
  }

  public Long getEmptySpace() {
    return emptySpace;
  }

  public void setEmptySpace(Long emptySpace) {
    this.emptySpace = emptySpace;
  }

  public String getRentPrice() {
    return rentPrice;
  }

  public void setRentPrice(String rentPrice) {
    this.rentPrice = rentPrice;
  }

  public String getServiceFee() {
    return serviceFee;
  }

  public void setServiceFee(String serviceFee) {
    this.serviceFee = serviceFee;
  }

  public String getBrokerageFee() {
    return brokerageFee;
  }

  public void setBrokerageFee(String brokerageFee) {
    this.brokerageFee = brokerageFee;
  }

  public String getRentArea() {
    return rentArea;
  }

  public void setRentArea(String rentArea) {
    this.rentArea = rentArea;
  }
}