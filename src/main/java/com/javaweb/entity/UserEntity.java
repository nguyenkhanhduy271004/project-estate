package com.javaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "user")
@NoArgsConstructor
@AllArgsConstructor
public class UserEntity extends BaseEntity {

  @Column(name = "username", nullable = false, unique = true)
  private String userName;

  @Column(name = "fullname", nullable = false)
  private String fullName;

  @Column(name = "password", nullable = false)
  private String password;

  @Column(name = "status", nullable = false)
  private Integer status;

  @Column(name = "email", unique = true)
  private String email;

  @ManyToMany(fetch = FetchType.LAZY)
  @JoinTable(name = "user_role",
      joinColumns = @JoinColumn(name = "user_id", nullable = false),
      inverseJoinColumns = @JoinColumn(name = "role_id", nullable = false))
  private List<RoleEntity> roles = new ArrayList<>();

  @OneToMany(mappedBy = "user", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
  private List<TransactionEntity> transactionEntities = new ArrayList<>();
}
