package com.javaweb.model.request;

import java.util.List;
import org.springframework.web.multipart.MultipartFile;

public class BuildingRequestDTO {

  private Long id;

  private String name;

  private String ward;

  private String street;

  private String district;

  private Long rentPrice;

  private String structure;

  private Long numberOfBasement;

  private Long floorArea;

  private String direction;

  private String level;

  private String rentArea;

  private String rentPriceDescription;

  private String serviceFee;

  private String carFee;

  private String motoFee;

  private String overtimeFee;

  private String electricityFee;

  private String deposit;

  private String payment;

  private String rentTime;

  private String decorationTime;

  private String managerName;

  private String managerPhone;

  private Long brokerageFee;

  private List<String> typeCode;

  private MultipartFile avatar;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public MultipartFile getAvatar() {
    return avatar;
  }

  public void setAvatar(MultipartFile avatar) {
    this.avatar = avatar;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getWard() {
    return ward;
  }

  public void setWard(String ward) {
    this.ward = ward;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
  }

  public Long getRentPrice() {
    return rentPrice;
  }

  public void setRentPrice(Long rentPrice) {
    this.rentPrice = rentPrice;
  }

  public String getStructure() {
    return structure;
  }

  public void setStructure(String structure) {
    this.structure = structure;
  }

  public Long getNumberOfBasement() {
    return numberOfBasement;
  }

  public void setNumberOfBasement(Long numberOfBasement) {
    this.numberOfBasement = numberOfBasement;
  }

  public Long getFloorArea() {
    return floorArea;
  }

  public void setFloorArea(Long floorArea) {
    this.floorArea = floorArea;
  }

  public String getDirection() {
    return direction;
  }

  public void setDirection(String direction) {
    this.direction = direction;
  }

  public String getLevel() {
    return level;
  }

  public void setLevel(String level) {
    this.level = level;
  }

  public String getRentArea() {
    return rentArea;
  }

  public void setRentArea(String rentArea) {
    this.rentArea = rentArea;
  }

  public String getRentPriceDescription() {
    return rentPriceDescription;
  }

  public void setRentPriceDescription(String rentPriceDescription) {
    this.rentPriceDescription = rentPriceDescription;
  }

  public String getServiceFee() {
    return serviceFee;
  }

  public void setServiceFee(String serviceFee) {
    this.serviceFee = serviceFee;
  }

  public String getCarFee() {
    return carFee;
  }

  public void setCarFee(String carFee) {
    this.carFee = carFee;
  }

  public String getMotoFee() {
    return motoFee;
  }

  public void setMotoFee(String motoFee) {
    this.motoFee = motoFee;
  }

  public String getOvertimeFee() {
    return overtimeFee;
  }

  public void setOvertimeFee(String overtimeFee) {
    this.overtimeFee = overtimeFee;
  }

  public String getElectricityFee() {
    return electricityFee;
  }

  public void setElectricityFee(String electricityFee) {
    this.electricityFee = electricityFee;
  }

  public String getDeposit() {
    return deposit;
  }

  public void setDeposit(String deposit) {
    this.deposit = deposit;
  }

  public String getPayment() {
    return payment;
  }

  public void setPayment(String payment) {
    this.payment = payment;
  }

  public String getRentTime() {
    return rentTime;
  }

  public void setRentTime(String rentTime) {
    this.rentTime = rentTime;
  }

  public String getDecorationTime() {
    return decorationTime;
  }

  public void setDecorationTime(String decorationTime) {
    this.decorationTime = decorationTime;
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

  public Long getBrokerageFee() {
    return brokerageFee;
  }

  public void setBrokerageFee(Long brokerageFee) {
    this.brokerageFee = brokerageFee;
  }

  public List<String> getTypeCode() {
    return typeCode;
  }

  public void setTypeCode(List<String> typeCode) {
    this.typeCode = typeCode;
  }
}
