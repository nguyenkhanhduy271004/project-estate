package com.javaweb.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "transaction")
@NoArgsConstructor
@AllArgsConstructor
public class TransactionEntity extends BaseEntity {

  @Column(name = "code")
  private String code;

  @Column(name = "note")
  private String note;

  @ManyToOne()
  @JoinColumn(name = "customerid")
  private CustomerEntity customer;

  @ManyToOne()
  @JoinColumn(name = "staffid")
  private UserEntity user;
  
}
