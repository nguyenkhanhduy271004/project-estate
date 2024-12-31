package com.javaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "rentarea")
@NoArgsConstructor
@AllArgsConstructor
public class RentAreaEntity extends BaseEntity {

  @Column(name = "value")
  private Long value;

  @ManyToOne()
  @JoinColumn(name = "buildingid")
  private BuildingEntity building;
  
}
