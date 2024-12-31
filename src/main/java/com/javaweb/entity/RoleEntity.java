package com.javaweb.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "role")
@NoArgsConstructor
@AllArgsConstructor
public class RoleEntity extends BaseEntity {

  @Column(name = "name")
  private String name;

  @Column(name = "code")
  private String code;

  @ManyToMany(mappedBy = "roles", fetch = FetchType.LAZY)
  private List<UserEntity> user = new ArrayList<>();


}
