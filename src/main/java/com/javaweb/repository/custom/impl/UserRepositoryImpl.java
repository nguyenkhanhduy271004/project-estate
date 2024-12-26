package com.javaweb.repository.custom.impl;

import com.javaweb.entity.UserEntity;
import com.javaweb.repository.custom.UserRepositoryCustom;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;

  public List<UserEntity> findByRole(String roleCode) {
    String sql = "SELECT u.* FROM user u " +
        "JOIN user_role ur ON ur.user_id = u.id " +
        "JOIN role r ON r.id = ur.role_id " +
        "WHERE r.code LIKE ?";

    Query query = entityManager.createNativeQuery(sql, UserEntity.class);

    query.setParameter(1, roleCode);

    return query.getResultList();
  }


  @Override
  public List<UserEntity> getAllUsers(Pageable pageable) {

    StringBuilder sql = new StringBuilder(buildQueryFilter())
        .append(" LIMIT ").append(pageable.getPageSize()).append("\n")
        .append(" OFFSET ").append(pageable.getOffset());
    System.out.println("Final query: " + sql.toString());

    Query query = entityManager.createNativeQuery(sql.toString(), UserEntity.class);
    return query.getResultList();
  }

  @Override
  public int countTotalItem() {
    String sql = buildQueryFilter();
    Query query = entityManager.createNativeQuery(sql.toString());
    return query.getResultList().size();
  }

  private String buildQueryFilter() {
    String sql = "SELECT * FROM user u WHERE u.status = 1";
    return sql;
  }
}
