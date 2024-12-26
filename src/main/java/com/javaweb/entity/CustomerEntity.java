package com.javaweb.entity;

import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "customer")
public class CustomerEntity extends BaseEntity {

  @Column(name = "fullname", nullable = false)
  private String fullName;

  @Column(name = "phone", nullable = false)
  private String phone;

  @Column(name = "email")
  private String email;

  @Column(name = "companyname")
  private String companyName;

  @Column(name = "demand")
  private String demand;

  @Column(name = "is_active")
  private Long isActive;

  @Column(name = "status")
  private String status;

  @Column(name = "note")
  private String note;

  @ManyToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  @JoinTable(name = "assignmentcustomer", joinColumns = @JoinColumn(name = "customerid", nullable = false),
      inverseJoinColumns = @JoinColumn(name = "staffid", nullable = false))
  private List<UserEntity> userEntityList = new ArrayList<>();

  @OneToMany(mappedBy = "customer", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<TransactionEntity> transactionEntities = new ArrayList<>();

  public List<UserEntity> getUserEntityList() {
    return userEntityList;
  }

  public void setUserEntityList(List<UserEntity> userEntityList) {
    this.userEntityList = userEntityList;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public Long getIsActive() {
    return isActive;
  }

  public void setIsActive(Long isActive) {
    this.isActive = isActive;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public String getDemand() {
    return demand;
  }

  public void setDemand(String demand) {
    this.demand = demand;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }

  public String getStatus() {
    return status;
  }
}
