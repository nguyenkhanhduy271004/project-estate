package com.javaweb.repository.custom;

import com.javaweb.builder.BuildingSearchBuilder;
import com.javaweb.entity.BuildingEntity;
import java.util.List;

public interface BuildingRepositoryCustom {

  List<BuildingEntity> findAll(BuildingSearchBuilder buildingSearchBuilder, int page, int size);

  Long count(BuildingSearchBuilder buildingSearchBuilder);

}

