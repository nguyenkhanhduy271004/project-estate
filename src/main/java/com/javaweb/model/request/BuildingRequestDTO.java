package com.javaweb.model.request;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import javax.validation.constraints.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BuildingRequestDTO {

  @Positive(message = "ID phải là số dương!")
  private Long id;

  @NotBlank(message = "Tên tòa nhà không được để trống!")
  private String name;

  private String ward;
  private String street;
  private String district;

  @PositiveOrZero(message = "Giá thuê phải lớn hơn hoặc bằng 0!")
  private Long rentPrice;

  private String structure;

  @PositiveOrZero(message = "Số tầng hầm phải lớn hơn hoặc bằng 0!")
  private Long numberOfBasement;

  @Positive(message = "Diện tích tầng phải là số dương!")
  private Long floorArea;

  private String direction;
  private String level;

  @NotBlank(message = "Kích thước khu vực thuê không được để trống!")
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

  @NotBlank(message = "Tên người quản lý không được để trống!")
  private String managerName;

  @Pattern(regexp = "\\d{10}", message = "Số điện thoại không hợp lệ! (10 chữ số)")
  private String managerPhone;

  private Long brokerageFee;
  private List<String> typeCode;
  private MultipartFile avatar;
}
