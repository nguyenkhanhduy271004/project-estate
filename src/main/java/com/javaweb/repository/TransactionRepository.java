package com.javaweb.repository;

import com.javaweb.entity.TransactionEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TransactionRepository extends JpaRepository<TransactionEntity, Long> {

  List<TransactionEntity> findAllByCustomerId(Long id);

}
