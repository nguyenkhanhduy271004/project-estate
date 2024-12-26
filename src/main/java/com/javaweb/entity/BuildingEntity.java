package com.javaweb.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "building")
public class BuildingEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "street")
  private String street;

  @Column(name = "ward")
  private String ward;

  @Column(name = "district")
  private String district;

  @Column(name = "structure")
  private String structure;

  @Column(name = "numberofbasement")
  private Long numberOfBasement;

  @Column(name = "floorarea")
  private Long floorArea;

  @Column(name = "direction")
  private String direction;

  @Column(name = "level")
  private String level;

  @Column(name = "rentprice")
  private Long rentPrice;

  @Column(name = "rentpricedescription")
  private String rentDescription;

  @Column(name = "servicefee")
  private String serviceFee;

  @Column(name = "carfee")
  private String carFee;

  @Column(name = "motofee")
  private String motoFee;

  @Column(name = "overtimefee")
  private String overtimeFee;

  @Column(name = "waterfee")
  private String waterFee;

  @Column(name = "electricityfee")
  private String electricityFee;

  @Column(name = "deposit")
  private String deposit;

  @Column(name = "payment")
  private String payment;

  @Column(name = "renttime")
  private String rentTime;

  @Column(name = "decorationtime")
  private String decorationTime;

  @Column(name = "brokeragefee")
  private Long brokerageFee;

  @Column(name = "type")
  private String type;

  @Column(name = "managername")
  private String managerName;


  @Column(name = "managerphone")
  private String managerPhone;

  @Column(name = "avatar")
  private String avatar;

  @OneToMany(mappedBy = "building", cascade = CascadeType.ALL)
  private List<RentAreaEntity> areas = new ArrayList<>();

  @ManyToMany(fetch = FetchType.LAZY, cascade = {CascadeType.MERGE, CascadeType.REMOVE})
  @JoinTable(name = "assignmentbuilding", joinColumns = @JoinColumn(name = "buildingid", nullable = false),
      inverseJoinColumns = @JoinColumn(name = "staffid", nullable = false))
  private List<UserEntity> userEntities = new ArrayList<>();

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getAvatar() {
    return avatar;
  }

  public void setAvatar(String avatar) {
    this.avatar = avatar;
  }

  public List<UserEntity> getUserEntities() {
    return userEntities;
  }

  public void setUserEntities(List<UserEntity> userEntities) {
    this.userEntities = userEntities;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getStreet() {
    return street;
  }

  public void setStreet(String street) {
    this.street = street;
  }

  public String getWard() {
    return ward;
  }

  public void setWard(String ward) {
    this.ward = ward;
  }

  public String getDistrict() {
    return district;
  }

  public void setDistrict(String district) {
    this.district = district;
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

  public Long getRentPrice() {
    return rentPrice;
  }

  public void setRentPrice(Long rentPrice) {
    this.rentPrice = rentPrice;
  }

  public String getRentDescription() {
    return rentDescription;
  }

  public void setRentDescription(String rentDescription) {
    this.rentDescription = rentDescription;
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

  public String getWaterFee() {
    return waterFee;
  }

  public void setWaterFee(String waterFee) {
    this.waterFee = waterFee;
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

  public Long getBrokerageFee() {
    return brokerageFee;
  }

  public void setBrokerageFee(Long brokerageFee) {
    this.brokerageFee = brokerageFee;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
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

  public List<RentAreaEntity> getAreas() {
    return areas;
  }

  public void setAreas(List<RentAreaEntity> areas) {
    this.areas = areas;
  }
}
