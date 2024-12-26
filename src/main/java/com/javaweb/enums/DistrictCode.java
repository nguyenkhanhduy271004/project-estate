package com.javaweb.enums;

import java.util.Map;
import java.util.TreeMap;

public enum DistrictCode {
  QUAN_1("Quận 1"),
  QUAN_2("Quận 2"),
  QUAN_3("Quận 3"),
  QUAN_4("Quận 4"),
  QUAN_5("Quận 5"),
  QUAN_6("Quận 6"),
  QUAN_7("Quận 7"),
  QUAN_8("Quận 8");
//  QUAN_9("Quận 9"),
//  QUAN_10("Quận 10"),
//  QUAN_11("Quận 11"),
//  QUAN_12("Quận 12"),
//  BINH_TAN("Quận Bình Tân"),
//  BINH_THANH("Quận Bình Thạnh"),
//  GO_VAP("Quận Gò Vấp"),
//  TAN_BINH("Quận Tân Bình"),
//  TAN_PHU("Quận Tân Phú"),
//  PHU_NHUAN("Quận Phú Nhuận"),
//  THU_DUC("Quận Thủ Đức");

  private final String districtName;

  DistrictCode(String districtName) {
    this.districtName = districtName;
  }

  public String getDistrictName() {
    return districtName;
  }


  public static Map<String, String> type() {
    Map<String, String> listType = new TreeMap<>();
    for (DistrictCode item : DistrictCode.values()) {
      listType.put(item.toString(), item.districtName);
    }
    return listType;
  }
}
