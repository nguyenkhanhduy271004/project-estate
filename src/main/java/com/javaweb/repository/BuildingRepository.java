package com.javaweb.repository;

import com.javaweb.repository.custom.BuildingRepositoryCustom;
import com.javaweb.entity.BuildingEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BuildingRepository extends JpaRepository<BuildingEntity, Long>,
    BuildingRepositoryCustom {

  void deleteByIdIn(List<Long> ids);
}

