package com.javaweb.model.request;

import java.util.List;

public class AssignmentBuildingRequest {

  private Long buildingId;
  private List<Long> staffs;

  public Long getBuildingId() {
    return buildingId;
  }

  public void setBuildingId(Long buildingId) {
    this.buildingId = buildingId;
  }

  public List<Long> getStaffs() {
    return staffs;
  }

  public void setStaffs(List<Long> staffs) {
    this.staffs = staffs;
  }
}
