package com.javaweb.converter.transaction;

import com.javaweb.entity.CustomerEntity;
import com.javaweb.entity.TransactionEntity;
import com.javaweb.model.request.TransactionRequest;
import com.javaweb.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TransactionEntityConverter {

  @Autowired
  private CustomerRepository customerRepository;

  public TransactionEntity toTransactionEntity(TransactionRequest transactionRequest) {
    TransactionEntity transactionEntity = new TransactionEntity();
    if (transactionRequest.getId() != null) {
      transactionEntity.setId(transactionRequest.getId());
    }
    transactionEntity.setCode(transactionRequest.getCode());
    transactionEntity.setNote(transactionRequest.getNote());
    CustomerEntity customer = customerRepository.findById(transactionRequest.getCustomerId()).get();
    transactionEntity.setCustomer(customer);
    return transactionEntity;
  }
}
