package com.javaweb.model.request;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

public class CustomerRequest {

  private Long id;

  @NotBlank(message = "Tên khách hàng không được để trống")
  private String fullName;

  @Email(message = "Email không đúng định dạng")
  private String email;

  @NotBlank(message = "Số điện thoại không được để trống")
  private String phone;
  private String note;
  private Long staffId;
  private String companyName;
  private String demand;
  private String status;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getStatus() {
    return status;
  }

  public void setStatus(String status) {
    this.status = status;
  }

  public String getDemand() {
    return demand;
  }

  public void setDemand(String demand) {
    this.demand = demand;
  }

  public String getCompanyName() {
    return companyName;
  }

  public void setCompanyName(String companyName) {
    this.companyName = companyName;
  }

  public Long getStaffId() {
    return staffId;
  }

  public void setStaffId(Long staffId) {
    this.staffId = staffId;
  }

  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhone() {
    return phone;
  }

  public void setPhone(String phone) {
    this.phone = phone;
  }

  public String getNote() {
    return note;
  }

  public void setNote(String note) {
    this.note = note;
  }
}
