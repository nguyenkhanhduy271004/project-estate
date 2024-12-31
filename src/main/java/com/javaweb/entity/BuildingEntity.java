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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "building")
@NoArgsConstructor
@AllArgsConstructor
public class BuildingEntity extends BaseEntity {

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
}
