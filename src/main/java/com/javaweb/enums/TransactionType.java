package com.javaweb.enums;

import java.util.*;

public enum TransactionType {
  CSKH("Chăm sóc khách hàng "),
  DDX("Dẫn đi xem ");

  private final String name;

  TransactionType(String name) {
    this.name = name;
  }

  public static Map<String, String> type() {
    Map<String, String> typeCodes = new HashMap<>();
    for (TransactionType item : TransactionType.values()) {
      typeCodes.put(item.toString(), item.name);
    }
    return typeCodes;
  }
}
