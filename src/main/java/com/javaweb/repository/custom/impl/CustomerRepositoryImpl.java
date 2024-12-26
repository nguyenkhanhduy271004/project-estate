package com.javaweb.repository.custom.impl;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.model.request.CustomerRequest;
import com.javaweb.repository.custom.CustomerRepositoryCustom;
import java.lang.reflect.Field;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class CustomerRepositoryImpl implements CustomerRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;

  public static void joinTable(CustomerRequest customerRequest, StringBuilder join) {
    Long staffId = customerRequest.getStaffId();
    if (staffId != null) {
      join.append(" INNER JOIN assignmentcustomer ON c.id = assignmentcustomer.customerid ");
    }
  }


  public static void queryNormal(CustomerRequest customerRequest, StringBuilder where) {
    try {
      Field[] fields = CustomerRequest.class.getDeclaredFields();
      for (Field item : fields) {
        item.setAccessible(true);
        String fieldName = item.getName();
        Object value = item.get(customerRequest);
        if (value != null) {
          if (!fieldName.equals("staffId")) {
            where.append(" AND c." + fieldName.toLowerCase() + " LIKE '%" + value + "%' ");
          } else {
            where.append(" AND assignmentcustomer." + fieldName.toLowerCase() + " = " + value);
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  @Override
  public List<CustomerEntity> findAll(CustomerRequest customerRequest, int page, int size) {
    StringBuilder sql = new StringBuilder("SELECT c.* FROM customer c");
    joinTable(customerRequest, sql);
    StringBuilder where = new StringBuilder(" WHERE 1=1");
    queryNormal(customerRequest, where);
    where.append(" GROUP BY c.id");
    sql.append(where);
    sql.append(" LIMIT ").append(size);
    sql.append(" OFFSET ").append((page - 1) * size);
    Query query = entityManager.createNativeQuery(sql.toString(), CustomerEntity.class);
    return query.getResultList();
  }
}
