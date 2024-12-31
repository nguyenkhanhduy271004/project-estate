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
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "customer")
@NoArgsConstructor
@AllArgsConstructor
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
  
}
