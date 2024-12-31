package com.javaweb.constant;

public class SecurityConstants {

  public static final String[] PUBLIC_URLS = {"/login", "/resource/**", "/trang-chu", "/api/**",
      "/customer/**"};
  public static final String[] STAFF_URLS = {"/admin/**", "/api/building/**", "/api/customer/**"};
  public static final String[] MANAGER_URLS = {"/admin/building-add", "/admin/building-edit-{id}",
      "/admin/building-delete-{id}", "/api/user/**"};
}
