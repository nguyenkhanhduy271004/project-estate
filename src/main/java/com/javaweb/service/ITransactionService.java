package com.javaweb.service;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import java.util.List;

public interface ITransactionService {

  void save(TransactionEntity transaction);

  List<TransactionEntity> findAllByCustomerId(Long id);

  TransactionEntity findById(Long id);

}
