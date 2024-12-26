package com.javaweb.service.impl;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.repository.TransactionRepository;
import com.javaweb.service.ITransactionService;
import java.util.Collections;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TransactionServiceImpl implements ITransactionService {

  @Autowired
  private TransactionRepository transactionRepository;

  @Override
  public void save(TransactionEntity transaction) {
    transactionRepository.save(transaction);
  }

  @Override
  public List<TransactionEntity> findAllByCustomerId(Long id) {
    return transactionRepository.findAllByCustomerId(id);
  }

  @Override
  public TransactionEntity findById(Long id) {
    return transactionRepository.findById(id).get();
  }
}
