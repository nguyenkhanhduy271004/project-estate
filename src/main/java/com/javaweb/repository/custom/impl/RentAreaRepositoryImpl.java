package com.javaweb.repository.custom.impl;

import com.javaweb.entity.RentAreaEntity;
import com.javaweb.repository.custom.RentAreaRepositoryCustom;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;

@Repository
public class RentAreaRepositoryImpl implements RentAreaRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;
  

  @Override
  public void deleteRentAreaWithBuildingId(Long id) {
    String sql = "DELETE FROM rentarea where buildingid = " + id;
    Query query = entityManager.createNativeQuery(sql);
    query.executeUpdate();
  }

}
