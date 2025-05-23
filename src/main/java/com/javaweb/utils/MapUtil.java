package com.javaweb.utils;

import java.util.Map;

public class MapUtil {

  public static <T> T getObject(Map<String, Object> params, String key, Class<T> tClass) {
    Object obj = params.getOrDefault(key, null);
    if (obj != null) {
      if (tClass == Long.class) {
        obj = !obj.toString().isEmpty() ? Long.valueOf(obj.toString()) : null;
      } else if (tClass == Integer.class) {
        obj = !obj.toString().isEmpty() ? Integer.valueOf(obj.toString()) : null;
      } else if (tClass == String.class) {
        obj = obj.toString();
      }
      return tClass.cast(obj);
    }
    return null;
  }

}
