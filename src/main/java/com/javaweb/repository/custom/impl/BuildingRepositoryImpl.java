package com.javaweb.repository.custom.impl;

import com.javaweb.entity.AssignmentBuildingEntity;
import com.javaweb.entity.RentAreaEntity;
import com.javaweb.model.request.AssignmentBuildingRequest;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.entity.BuildingEntity;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class BuildingRepositoryImpl implements BuildingRepositoryCustom {

  @PersistenceContext
  private EntityManager entityManager;


  public static void joinTable(BuildingSearchBuilder buildingSearchBuilder, StringBuilder join) {
    Long staffId = buildingSearchBuilder.getStaffId();
    if (staffId != null) {
      join.append(" INNER JOIN assignmentbuilding ON b.id = assignmentbuilding.buildingid ");
    }
    List<String> typeCode = buildingSearchBuilder.getTypeCode();
//    if (typeCode != null && !typeCode.isEmpty()) {
//      join.append(" INNER JOIN buildingrenttype ON b.id = buildingrenttype.buildingid ");
//      join.append(" INNER JOIN renttype ON b.id = buildingrenttype.renttypeid ");
//    }

  }

  public static void queryNormal(BuildingSearchBuilder buildingSearchBuilder, StringBuilder where) {
    try {
      Field[] fields = BuildingSearchBuilder.class.getDeclaredFields();
      for (Field item : fields) {
        item.setAccessible(true);
        String fieldName = item.getName();
        if (!fieldName.equals("staffId") && !fieldName.equals("typeCode") && !fieldName.startsWith(
            "area")
            && !fieldName.startsWith("rentPrice")) {
          Object value = item.get(buildingSearchBuilder);
          if (value != null) {
            if ((item.getType().getName().equals("java.lang.Long")
                || item.getType().getName().equals("java.lang.Integer"))
                && !fieldName.equals("managerPhone")) {
              where.append(" AND b." + fieldName.toLowerCase() + " = " + value);
            } else {
              if (!fieldName.equals("district")) {
                where.append(" AND b." + fieldName.toLowerCase() + " LIKE '%" + value + "%' ");
              } else {
                if (!value.toString().equals("")) {
                  where.append(" AND b." + fieldName.toLowerCase() + " LIKE '" + value + "' ");
                }
              }
            }
          }
        }
      }
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public static void querySpecial(BuildingSearchBuilder buildingSearchBuilder,
      StringBuilder where) {
    Long staffId = buildingSearchBuilder.getStaffId();
    if (staffId != null) {
      where.append(" AND assignmentbuilding.staffid = " + staffId);
    }

    Object rentAreaFrom = buildingSearchBuilder.getAreaFrom();
    Object rentAreaTo = buildingSearchBuilder.getAreaTo();

    if (rentAreaFrom != null || rentAreaTo != null) {
      where.append(" AND EXISTS (SELECT * FROM rentarea r WHERE b.id = r.buildingid");
      if (rentAreaFrom != null) {
        where.append(" AND r.value >= " + rentAreaFrom);
      }
      if (rentAreaTo != null) {
        where.append(" AND r.value <= " + rentAreaTo);
      }
      where.append(") ");
    }

    Long rentPriceFrom = buildingSearchBuilder.getRentPriceFrom();
    Long rentPriceTo = buildingSearchBuilder.getRentPriceTo();

    if (rentPriceFrom != null || rentPriceTo != null) {
      if (rentPriceFrom != null) {
        where.append(" AND b.rentprice >= " + rentPriceFrom);
      }
      if (rentPriceTo != null) {
        where.append(" AND b.rentprice <= " + rentPriceTo);
      }
    }

    List<String> typeCode = buildingSearchBuilder.getTypeCode();

    if (typeCode != null && typeCode.size() != 0) {
      where.append(" AND(");
      String sql = typeCode.stream().map(it -> "b.type LIKE" + "'%" + it + "%' ")
          .collect(Collectors.joining(" OR "));
      where.append(sql + ") ");
    }
  }

  @Override
  public List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder, int page,
      int size) {
    StringBuilder sql = new StringBuilder("SELECT b.* FROM building b ");
    joinTable(buildingSearchBuilder, sql);
    StringBuilder where = new StringBuilder(" WHERE 1=1");
    queryNormal(buildingSearchBuilder, where);
    querySpecial(buildingSearchBuilder, where);
    where.append(" GROUP BY b.id");
    sql.append(where);
    sql.append(" LIMIT ").append(size);
    sql.append(" OFFSET ").append((page - 1) * size);
    Query query = entityManager.createNativeQuery(sql.toString(), BuildingEntity.class);
    return query.getResultList();
  }

  @Override
  public Long count(BuildingSearchBuilder buildingSearchBuilder) {
    StringBuilder sql = new StringBuilder("SELECT COUNT(DISTINCT b.id) FROM building b ");
    joinTable(buildingSearchBuilder, sql);
    StringBuilder where = new StringBuilder(" WHERE 1=1");
    queryNormal(buildingSearchBuilder, where);
    querySpecial(buildingSearchBuilder, where);
    sql.append(where);
    Query query = entityManager.createNativeQuery(sql.toString());
    return ((Number) query.getSingleResult()).longValue();
  }


}
